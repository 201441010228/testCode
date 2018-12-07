//package com.com.lastWork;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class GetRequestJsonObject {
//
//    public  static  final  String  REQUEST = "Request";
//    public  static  final  String  LIST = "list";
//    public  static  final  String  ITEM = "item";
//
//    /**
//     * 传入具体的map参数
//     * @param o
//     * @return
//     */
//    public static JSONObject getRequest(Object o){
//        JSONObject j1 = new JSONObject();
//        JSONObject j2 = new JSONObject();
//        JSONObject j3 = new JSONObject();
//        j1.put(ITEM,o);
//        j2.put(LIST,j1);
//        j3.put(REQUEST,j2);
//        return j3;
//    }
//
//}
