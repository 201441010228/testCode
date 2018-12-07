package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2018/9/3 15:53
 * @Description:
 */
public class TEKVTest<T> {
   private String name;
   public void printMessage(T t){
       System.out.println(t.toString());
   }

    public void printMessage2(TEKVTest<? extends T> t){
        System.out.println(t.toString());
    }
}
