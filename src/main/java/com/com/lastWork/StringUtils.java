package com.com.lastWork;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONObject;

public class StringUtils {

    public static void main(String[] args) {
//        String url = "http://inside-native-lbs.01zhuanche.com/city/location";
//        Map parmas = new HashMap();
//        parmas.put("coordType","mars");
//        parmas.put("platform","5");
//        System.out.println(parmas);
//        parmas.clear();
//        System.out.println(parmas);
//        String encoding = "utf-8";
//        String body = sendPost(url,parmas,encoding);
//        System.out.println(body);
        System.out.println('\001');
    }


    public static String sendPost(String url, Map<String, String> paramMap, String encoding) {
        String body = "";
        CloseableHttpClient client=HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (paramMap != null) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
                httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            } catch (UnsupportedEncodingException e) {
                throw new Exception(e);
            }
            int i = 0;
            while (i < 3) {
                try {
                    CloseableHttpResponse response = client.execute(httpPost);
                    if (response != null) {
                        HttpEntity entity = response.getEntity();
                        int statusCode = response.getStatusLine().getStatusCode();
                        if (entity != null && statusCode== 200) {
                            body = EntityUtils.toString(entity, encoding);
                            JSONObject jsonObject = new JSONObject(body);
                            Integer code = jsonObject.getInt("code");
                            if (code == 0) {
                                JSONObject data = jsonObject.getJSONObject("data");
                                body = data.getString("adcode");
                            }
                        }
                        EntityUtils.consume(entity);
                        response.close();
                        if (statusCode==200){
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i == 2) {
                    String err = String.format("调用LBS接口失败，调用参数:%s,%s，调用结果：%s",paramMap.get("lng"),paramMap.get("lat"), body);
                    throw new Exception(err);
                }
                i++;
            }
        } catch (Exception e) {

        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }

}
