package mcquick.agentApiDemo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;

public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static final int TIMEOUT = 60000;
    public static final int SO_TIMEOUT = 60000;
    public static final int MAX_TOTAL = 50;

    private HttpUtils() {

    }

    private static CloseableHttpClient getHttpClient(Integer timeout, boolean isHttps) throws Exception {

        SSLConnectionSocketFactory sslsf = null;
        if (isHttps) {
            X509TrustManager x509mgr = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[]{x509mgr}, null);

            sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2" },
                    null, NoopHostnameVerifier.INSTANCE);
        }

        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        registryBuilder.register("http", PlainConnectionSocketFactory.getSocketFactory());
        if (isHttps) {
            registryBuilder.register("https", sslsf).build();
        }

        Registry<ConnectionSocketFactory> socketFactoryRegistry = registryBuilder.build();
        //创建httpclient连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        //设置连接池线程最大数量
        cm.setMaxTotal(MAX_TOTAL);
        //创建http request的配置信息
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout == null ? TIMEOUT : timeout)
                .setSocketTimeout(timeout == null ? SO_TIMEOUT : timeout).build();

        //初始化httpclient客户端
        HttpClientBuilder clientBuilder = HttpClients.custom();
        clientBuilder.setConnectionManager(cm).setDefaultRequestConfig(config);
        if (isHttps) {
            clientBuilder.setSSLSocketFactory(sslsf);
        }
        return clientBuilder.build();
    }

    public static String post(String url, String jsonParams, Integer timeout, boolean isHttps) {
        try {
            CloseableHttpClient client = getHttpClient(timeout, isHttps);
            HttpPost post = new HttpPost(url);
            StringEntity paramEntity = new StringEntity(jsonParams, StandardCharsets.UTF_8);
            post.setEntity(paramEntity);
            post.setHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
            HttpResponse resp = client.execute(post);
            int statusCode = resp.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                logger.warn("~~~~~ post ~~~~~  request error,HttpCode:{},url:{}", statusCode, url);
                return null;
            }
            HttpEntity entity = resp.getEntity();
            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        } catch (ClientProtocolException e) {
            logger.warn("~~~~~ post ~~~~~ 出现异常（ClientProtocolException）", e);
        } catch (IOException e) {
            logger.warn("~~~~~ post ~~~~~  出现异常（IOException）", e);
        } catch (Exception e) {
            logger.warn("~~~~~ post ~~~~~  出现异常（Exception）", e);
        }
        return null;
    }
}
