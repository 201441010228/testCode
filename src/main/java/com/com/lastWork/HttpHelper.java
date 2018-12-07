//package com.com.lastWork;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.message.BasicNameValuePair;
//import java.utils.LinkedList;
//import java.utils.List;
//import java.utils.Map;
//
//public class HttpHelper {
//
//    private static String UTF8 = "UTF-8";
//    private static RequestConfig requestConfig;
//
//    /**
//     * @param header
//     * @param params
//     * @param url
//     * @return
//     * @throws Exception
//     */
//    public static JSONObject post(Map<String, String> header, Map<String, String> params, String url) throws Exception {
//        HttpPost post = null;
//        post = new HttpPost(url);
//        if (header != null) {
//            for (String key : header.keySet()) {
//                post.addHeader(key, header.get(key));
//            }
//        }
//        if (params != null) {
//            List<BasicNameValuePair> list = new LinkedList<BasicNameValuePair>();
//            post.setConfig(getRequestConfig());
//            for (String key : params.keySet()) {
//                list.add(new BasicNameValuePair(key, params.get(key)));
//            }
//            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, UTF8);
//            post.setEntity(entity);
//        }
//        return HttpClientHelper.getHttpClient().executeJsonData(post);
//    }
//
//    /**
//     * @param header
//     * @param jsonObject
//     * @param url
//     * @return
//     * @throws Exception
//     */
//    public static JSONObject post(Map<String, String> header, String jsonObject, String url) throws Exception {
//        HttpPost post = null;
//        post = new HttpPost(url);
//        if (header != null) {
//            for (String key : header.keySet()) {
//                post.addHeader(key, header.get(key));
//            }
//        }
//        if (jsonObject == null) {
//            throw new Exception("jsonObject不能为空！");
//        }
//        return HttpClientHelper.getHttpClient().executeJsonData(post);
//    }
//
//    /**
//     * @param params
//     * @param url
//     * @return
//     * @throws Exception
//     */
//    public static JSONObject post(Map<String, String> params, String url) throws Exception {
//        HttpPost post = null;
//        post = new HttpPost(url);
//        List<BasicNameValuePair> list = new LinkedList<BasicNameValuePair>();
//        post.setConfig(getRequestConfig());
//        for (String key : params.keySet()) {
//            list.add(new BasicNameValuePair(key, params.get(key)));
//        }
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, UTF8);
//        post.setEntity(entity);
//        return HttpClientHelper.getHttpClient().executeJsonData(post);
//    }
//
//    /**
//     * @param jsonObject
//     * @param url
//     * @return
//     * @throws Exception
//     */
//    public static JSONObject post(JSONObject jsonObject, String url) throws Exception {
//        HttpPost post = null;
//        post = new HttpPost(url);
//        StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");//解决中文乱码问题
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/json");
//        post.setEntity(entity);
//        return HttpClientHelper.getHttpClient().executeJsonData(post);
//    }
//
//    /**
//     * @return
//     */
//    public static RequestConfig getRequestConfig() {
//        if (requestConfig == null) {
//            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000)
//                    .setConnectTimeout(20000).setSocketTimeout(20000).build();
//        }
//        return requestConfig;
//    }
//}