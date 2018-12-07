//package com.com.lastWork;
//
//import com.alibaba.fastjson.JSONObject;
//
//
//import java.utils.HashMap;
//import java.utils.Map;
//
//public class Test {
//
//    public  static  final  String URL = "http://125.68.186.81:14119/WP_LZLJ_SOA/APP_PUBLIC_SERVICES/Proxy_Services/LZLJ_091_Authentication_PS";
//    public static void main(String[] args) throws Exception {
//        Long time2 = System.currentTimeMillis();
//        JSONObject jsonObject = HttpHelper.post(requistParams(),URL);
//        System.out.println(System.currentTimeMillis()-time2);
//        System.out.println(jsonObject);
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("222","2222");
//        System.out.println(GetRequestJsonObject.getRequest(map));
////        HttpClient client = new DefaultHttpClient();
////        HttpPost request;
////        try {
////            request = new HttpPost(new URI(URL));
////            if(jsonObject!= null){
////                StringEntity s = new StringEntity(jsonObject.toString(),"utf-8");
////                s.setContentType("application/json");
////                request.setEntity(s);
////            }
////            HttpResponse response = client.execute(request);
////            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
////                String result = EntityUtils.toString(response.getEntity());// 返回json格式：
////                JSONObject responseJsonObject = JSONObject.parseObject(result);
////                System.out.println(responseJsonObject);
////            }
////        }catch (Exception e){
////
////         }
//
//    }
//
//
////    private Map<String, String> requistHeader() {
////        Map<String, String> header = new HashMap<String, String>();
////        header.put("COUNT", "1");
////        header.put("SRVLEVEL", "1");
////        header.put("BIZTRANSACTIONID", "weaveroa_1523117384431");
////        header.put("PASSWORD", "");
////        header.put("ACCOUNT", "");
////        header.put("CONSUMER", "portal");
////        return header;
////    }
//
//    private static JSONObject requistParams(){
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("action", "authLogin");
//            jsonObject.put("appid", "weaver");
//            jsonObject.put("loginid","weaver444");
//            jsonObject.put("password","authLogin");
//            JSONObject jsonObject1 = new JSONObject();
//            jsonObject1.put("item",jsonObject);
//            JSONObject jsonObject2 = new JSONObject();
//            jsonObject2.put("list",jsonObject1);
//            JSONObject jsonObject3 = new JSONObject();
//            jsonObject3.put("Request",jsonObject2);
//            System.out.println(jsonObject3.toString());
//            return jsonObject3;
//    }
//
////    public static  JSONObject receivePost(HttpServletRequest request){
////
////        StringBuilder sb = new StringBuilder();
////        JSONObject json=null;
////        try {
////            // 读取请求内容
////            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
////            String line = null;
////            while ((line = br.readLine()) != null) {
////                sb.append(line);
////            }
////            //将json字符串转换为json对象
////            json=JSONObject.parseObject(sb.toString());
////        } catch (Exception e) {
////
////        }
////
////        return json;
////    }
//
//
//
//}
