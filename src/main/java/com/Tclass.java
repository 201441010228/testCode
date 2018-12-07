package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张扬
 * @Date: 2018/10/17 18:31
 * @Description:
 */
public class Tclass {

    private static <T> void listAddAllAvoidNPE(List<T> dest, List<T> source) {
        if (source == null) {
            return;
        }
        dest.addAll(source);
    }

    private static <T> void listAddAvoidNull(List<T> dest, T source) {
        if (source == null) {
            return;
        }
        dest.add(source);
    }

    public static void main(String args[]){
        List<Integer> integers = new ArrayList<Integer>();
        Tclass.listAddAvoidNull(integers,1);
    }

}
