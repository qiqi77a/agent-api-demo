package mcquick.agentApiDemo.util;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

public class FileToStringUtils {
    /**
     * 将图片转换为字节数组
     */
    protected static byte[] loadImage(InputStream stream) {
        //用于返回的字节数组
        byte[] data = null;
        //打开字节输出流
        ByteArrayOutputStream bout = null;
        try {
            //输出流定义缓冲区大小
            bout = new ByteArrayOutputStream(stream.available());
            //定义字节数组，用于读取文件流
            byte[] buffer = new byte[1024];
            //用于表示读取的位置
            int len = -1;
            //开始读取文件
            while ((len = stream.read(buffer)) != -1) {
                //从buffer的第0位置开始，读取至第len位置，结果写入bout
                bout.write(buffer, 0, len);
            }
            //将输出流转为字节数组
            data = bout.toByteArray();
            //关闭输入输出流
            stream.close();
            bout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 压缩字符串
     */
    protected static String compress(byte[] data) {
        String finalData = null;
        try {
            //打开字节输出流
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            //打开压缩用的输出流,压缩后的结果放在bout中
            GZIPOutputStream gout = new GZIPOutputStream(bout);
            //写入待压缩的字节数组
            gout.write(data);
            //完成压缩写入
            gout.finish();
            //关闭输出流
            gout.close();
            finalData = new BASE64Encoder().encode(bout.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalData;
    }
}
