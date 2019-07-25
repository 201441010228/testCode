package com;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @Auther: 张扬
 * @Date: 2018/11/2 13:49
 * @Description:
 */
public class util {

    public static  void  main(String args[]){
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 2){
                iterator.remove();
            }
        }
        System.out.println(deque);
    }

    private static  String getValue(String message, String findFile) {
         findFile = findFile + "=";
        String rmessage = "";
        int startOffset = findFile.length();
        try {
            System.out.println(message.indexOf(findFile) + startOffset);
            rmessage=  message.substring(message.indexOf(findFile) + startOffset,
                                         message.indexOf(",", message.indexOf(findFile)));
        }catch (Exception e){
            return "null";
        }
        return rmessage;
    }


    public  static Map<String,String> post(String url,String content) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).build();
        RequestBody formBody = new FormBody.Builder()
                .add("userName","userName")
                .add("password","password")
                .add("mobile","15811082583,15659379647")
                .add("msg", URLEncoder.encode(content,"GBK"))
                .add("key","sdasdasdada")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-type","application/x-www-form-urlencoded")
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body().string(),Map.class);
    }
}
