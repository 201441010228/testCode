//package com.com.lastWork;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.utils.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.utils.concurrent.locks.Lock;
//import java.utils.concurrent.locks.ReentrantLock;
//
//public class HttpClientHelper {
//
//    private static Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);
//    private static HttpClientHelper instance = null;
//    private static Lock lock = new ReentrantLock();
//    private static CloseableHttpClient httpClient;
//
//    public HttpClientHelper() {
//        instance = this;
//    }
//
//    public static HttpClientHelper getHttpClient() {
//        if (instance == null) {
//            lock.lock();
//            try {
//                instance = new HttpClientHelper();
//            } catch (Exception e) {
//                logger.error(e.getMessage());
//            } finally {
//                lock.unlock();
//            }
//        }
//        return instance;
//    }
//
//    public void init() {
//        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
//        pool.setMaxTotal(500);
//        pool.setDefaultMaxPerRoute(50);
//        httpClient = HttpClientBuilder.create().setConnectionManager(pool).build();
//    }
//
//    public JSONObject executeAndReturnObject(HttpRequestBase request) throws Exception {
//        CloseableHttpResponse response = null;
//        JSONObject responseJsonObject = null;
//        if (request == null) {
//            return null;
//        }
//        if (httpClient == null) {
//            init();
//        }
//        if (httpClient == null) {
//            logger.error("http获取异常");
//            return  null;
//        }
//        Long time1 =  System.currentTimeMillis();
//        response = httpClient.execute(request);
//        System.out.println(System.currentTimeMillis()-time1);
//        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            String result = EntityUtils.toString(response.getEntity());// 返回json格式：
//            responseJsonObject = JSONObject.parseObject(result);
//        }
//        return responseJsonObject;
//    }
//
//    /**
//     * 若想返回值为string 类型 启用此方法
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    public String executeStringData(HttpRequestBase request) throws Exception {
//        JSONObject base = executeAndReturnObject(request);
//        if (base == null) {
//            return null;
//        }
//        return base.getString("UTF-8");
//    }
//
//    /**
//     *
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    public JSONObject executeJsonData(HttpRequestBase request) throws Exception {
//        return executeAndReturnObject(request);
//    }
//
//}