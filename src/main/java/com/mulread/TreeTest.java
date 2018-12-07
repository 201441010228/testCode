package com.mulread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ss.formula.functions.T;
import sun.reflect.generics.tree.Tree;

/**
 * @Auther: 张扬
 * @Date: 2018/8/22 10:00
 * @Description:
 */
public class TreeTest<T1, T2> {

    public static void main(String args[]) {
        System.out.println(new TreeTest().getT1());
        System.out.println(new TreeTest().getT2());
        new TreeTest<String,String>().getClassName(1);

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
