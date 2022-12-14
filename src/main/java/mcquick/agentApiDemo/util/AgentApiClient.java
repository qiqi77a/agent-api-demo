package mcquick.agentApiDemo.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson2.*;
import mcquick.agentApiDemo.entity.response.base.BaseCallBackRsp;
import mcquick.agentApiDemo.entity.response.base.BaseRsp;
import mcquick.agentApiDemo.exception.CheckException;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentApiClient {
    private String agentId;
    private String host;
    private String key;
    private Boolean isHttps = false;

    private AgentApiClient() {
    }

    public AgentApiClient(String agentId, String host, String key) {
        this.agentId = agentId;
        this.host = host;
        this.key = key;
    }

    public BaseRsp<?> send(Object req) {
        Assert.isNotNull(req, new CheckException("req不能为空"));
        UrlConstant urlTool = UrlConstant.getUrlConstantByReq(req.getClass());
        Assert.isNotNull(urlTool, new CheckException("没有这个请求接口！"));
        return send(req, urlTool, UrlConstant.getRspByReq(req.getClass()));
    }

    public <T> BaseRsp<T> send(Object req, Class<T> rsp) {
        Assert.isNotNull(req, new CheckException("req不能为空"));
        UrlConstant urlTool = UrlConstant.getUrlConstantByReq(req.getClass());
        Assert.isNotNull(urlTool, new CheckException("没有这个请求接口！"));
        Assert.isTrue(urlTool.getRsp().equals(rsp), "不支持这类返回值，请参考UrlConstant！");
        return send(req, urlTool, rsp);
    }

    public <T> BaseRsp<T> send(Class<T> rsp) {
        UrlConstant urlTool = UrlConstant.getUrlConstantByRsp(rsp.getClass());
        Assert.isNotNull(urlTool, new CheckException("没有这个请求接口！"));
        Assert.isTrue(urlTool.getRsp().equals(rsp), "不支持这类返回值，请参考UrlConstant！");
        return send(null, urlTool, rsp);
    }


    public <T> BaseRsp<List<T>> sendRList(Class<T> rsp) {
        return send(new TypeReference<List<T>>(rsp) {});
    }

    /**
     * @param req     请求参数
     * @param ListRsp 返回值,仅支持List<T>类型
     * @param <T>     参考UrlConstant
     */
    public <T> BaseRsp<T> send(Object req, TypeReference<T> ListRsp) {
        Class<?> rsp = getaClass(ListRsp);
        UrlConstant urlTool = UrlConstant.getUrlConstantByReq(req.getClass());
        Assert.isNotNull(urlTool, new CheckException("没有这个请求接口！"));
        Assert.isTrue(ListRsp.getRawType().equals(List.class) && urlTool.getRsp().equals(rsp), "不支持这类返回值，请参考UrlConstant！");
        return send(req, urlTool, ListRsp);
    }

    /**
     * @param ListRsp 返回值,仅支持List<T>类型
     * @param <T>     参考UrlConstant
     */
    public <T> BaseRsp<T> send(TypeReference<T> ListRsp) {
        Class<?> rsp = getaClass(ListRsp);
        UrlConstant urlTool = UrlConstant.getUrlConstantByRsp(rsp);
        Assert.isNotNull(urlTool, new CheckException("没有这个请求接口！"));
        Assert.isTrue(ListRsp.getRawType().equals(List.class) && urlTool.getRsp().equals(rsp), "不支持这类返回值，请参考UrlConstant！");
        return send(null, urlTool, ListRsp);
    }

    private <T> Class<?> getaClass(TypeReference<T> ListRsp) {
        Class<?> rsp = null;
        String typeName = null;
        try {
            Type type = ((ParameterizedType) ListRsp.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            typeName = ((ParameterizedType) type).getActualTypeArguments()[0].getTypeName();
            rsp = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new CheckException("参数ListRsp仅支持List<T>类型，找不到类" + typeName);
        }
        return rsp;
    }

    public <T> BaseRsp<T> send(Object req, UrlConstant urlTool, TypeReference<T> typeReference) {
        //请求前置处理
        Map<String, Object> reqMap = preSend(req);

        //发送请求
        String path = urlTool.getUrl();
        System.out.println("url>>>" + host + path);
        System.out.println("reqData>>>" + JSON.toJSONString(reqMap));
        String resp = HttpUtils.post(host + path, JSON.toJSONString(reqMap), HttpUtils.TIMEOUT, isHttps);

        //返回值处理
        return afterSend(typeReference, resp);
    }

    public <T> BaseRsp<T> send(Object req, UrlConstant urlTool, Class<T> rsp) {
        //请求前置处理
        Map<String, Object> reqMap = preSend(req);

        //发送请求
        String path = urlTool.getUrl();
        System.out.println("url>>>" + host + path);
        System.out.println("reqData>>>" + JSON.toJSONString(reqMap));
        String resp = HttpUtils.post(host + path, JSON.toJSONString(reqMap), HttpUtils.TIMEOUT, isHttps);

        //返回值处理
        return afterSend(rsp, resp);
    }

    public String buildCall(BaseCallBackRsp req) {
        String data = JSON.toJSONString(req);
        //加密
        String encryptBase64Data = SecureUtil.aes(key.getBytes()).encryptBase64(data);
        //组装参数
        Map<String, Object> rspMap = new HashMap<>();
        rspMap.put("agentId", agentId);
        rspMap.put("data", encryptBase64Data);
        return JSON.toJSONString(rspMap);
    }

    private Map<String, Object> preSend(Object req) {
        //判断是否是文件上传
        String data = JSON.toJSONString(req);
        JSONObject jsonObject = JSON.parseObject(data);
        File file = null;
        if (jsonObject != null) {
            file = jsonObject.getObject("file", File.class);
        }

        if (file != null) {
            //限制图片类型 仅限jpg图片
            String fileName = file.getName();
            Assert.isTrue(!fileName.equals(""), new CheckException("文件名不能为空"));
            String[] strings = fileName.split("\\.");

            System.out.println(fileName);
            Assert.isTrue(strings.length >= 2 && strings[strings.length - 1].equals("jpg"), new CheckException("图片必须是jpg类型"));
            //限制图片大小
            Assert.isTrue(file.exists(), new CheckException("图片不存在"));
            InputStream stream = null;
            try {
                stream = ImageUtils.squeeze(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
                throw new CheckException(e.getMessage());
            }
            //将文件转为字节数组
            byte[] loadImage = FileToStringUtils.loadImage(stream);
            //压缩String  GZIPOutputStream BASE64Encoder
            String fileString = FileToStringUtils.compress(loadImage);

            //重新设置图片
            jsonObject.put("file", fileString);
            data = JSON.toJSONString(jsonObject);
            System.out.println("newData>>>" + data);
        }

        //加密
        String encryptBase64Data = SecureUtil.aes(key.getBytes()).encryptBase64(data);
        //组装参数
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("agentId", agentId);
        reqMap.put("data", encryptBase64Data);
        return reqMap;
    }

    private <T> BaseRsp<T> afterSend(TypeReference<T> typeReference, String resp) {
        //处理返回参数
        if (StrUtil.isBlank(resp)) {
            throw new CheckException("渠道响应数据为空");
        }
        JSONObject obj = JSON.parseObject(resp);
        if (StrUtil.isBlank(obj.getString("code"))) {
            throw new CheckException("返回信息错误");
        } else if (StrUtil.isNotBlank(obj.getString("data")) && StrUtil.isNotBlank(obj.getString("agentId")) && obj.getString("agentId").equals(agentId)) {
            //解密
            String dataJson = obj.getString("data");
            System.out.println("dataJson>>>" + dataJson);
            String decryptStrData = SecureUtil.aes(key.getBytes()).decryptStr(dataJson);
            obj.put("data", decryptStrData);
            T o = JSON.parseObject(decryptStrData, typeReference);
            //组装返回值
            BaseRsp<T> result = new BaseRsp<>();
            result.setCode(obj.getInteger("code"));
            result.setMsg(obj.getString("msg"));
            result.setData(o);
            return result;
        } else {
            //data为空不用解密
            return JSON.parseObject(resp, new TypeReference<BaseRsp<T>>() {});
        }
    }

    public <T> BaseRsp<T> afterSend(Class<T> rsp, String resp) {
        //处理返回参数
        System.out.println("resp>>>"+resp);
        if (StrUtil.isBlank(resp)) {
            throw new CheckException("渠道响应数据为空");
        }
        JSONObject obj = JSON.parseObject(resp);
        if (StrUtil.isBlank(obj.getString("code"))) {
            throw new CheckException("返回信息错误");
        } else if (StrUtil.isNotBlank(obj.getString("data")) && StrUtil.isNotBlank(obj.getString("agentId")) && obj.getString("agentId").equals(agentId)) {
            //解密
            String dataJson = obj.getString("data");
            System.out.println("dataJson>>>" + dataJson);
            String decryptStrData = SecureUtil.aes(key.getBytes()).decryptStr(dataJson);
            obj.put("data", decryptStrData);
            T o = JSON.parseObject(decryptStrData, rsp);
            //组装返回值
            BaseRsp<T> result = new BaseRsp<>();
            result.setCode(obj.getInteger("code"));
            result.setMsg(obj.getString("msg"));
            result.setData(o);
            return result;
        } else {
            //data为空或agentId为空，不用解密
            return JSON.parseObject(resp, new TypeReference<BaseRsp<T>>(rsp) {});
        }
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}