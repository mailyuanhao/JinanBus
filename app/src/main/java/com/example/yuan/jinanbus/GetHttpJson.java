package com.example.yuan.jinanbus;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 从网上下载信息
 * "UTF-8"
 * Created by Yuan on 2015/3/18.
 */
@SuppressWarnings("ALL")
class GetHttpJson {
    private static final String sTAG = "GetHttpJson";

    public static String getURLContentString(String path) {
        String ret = null;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 利用HttpURLConnection对象,我们可以从网络中获取网页数据.
            conn.setConnectTimeout(5 * 1000);   // 单位是毫秒，设置超时时间为5秒
            conn.setRequestMethod("GET");       // HttpURLConnection是通过HTTP协议请求path路径的，所以需要设置请求方式,可以不设置，因为默认为GET
            int iCode = conn.getResponseCode();
            if (iCode == HttpURLConnection.HTTP_OK) {// 判断请求码是否是200码，否则失败
                InputStream is = conn.getInputStream();// 获取输入流)
                try {
                    byte[] data = readStream(is);   // 把输入流转换成字符数组
                    ret = new String(data, "UTF-8"); // 把字符数组转换成字符串
                } finally {
                    is.close();
                }
            }
        } catch (IOException e) {
            Log.d(sTAG, e.toString());
        }
        return ret;
    }

    /**
     * 把输入流转换成字符数组
     *
     * @param inputStream 输入流
     * @return 字符数组
     * @throws IOException
     */
    private static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                bout.write(buffer, 0, len);
            }
        } finally {
            bout.close();
        }

        return bout.toByteArray();
    }
}
