package com.com.lastWork;


public class Test {

    public static void main(String[] args){
         StringBuffer s = new StringBuffer();
         s.append("1223234,");
         s.deleteCharAt(s.length()-1);
        System.out.println(s.toString());
    }

}

