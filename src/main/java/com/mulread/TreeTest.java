package com.mulread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 张扬
 * @Date: 2018/8/22 10:00
 * @Description:
 */
public class TreeTest<T1, T2> {

    private  static  Integer num = 1;
    private static Map<String,Integer> map = new HashMap<>();
    static {
        map.put("num",num);
    }
    public static void main(String args[]) {
      Integer num = map.get("num");
      num =2;
        System.out.println(map.get("num"));

    }

    public T1 getT1(){
        return (T1) "T1";
    }


    public T2 getT2(){
        return (T2) "T2";
    }

    public <T> void getClassName(T x){
        System.out.println(x.getClass().getName());
    }
}
