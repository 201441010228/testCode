package com.io;

/**
 * @Auther: 张扬
 * @Date: 2018/7/25 18:20
 * @Description:
 */
public class AddClass implements Runnable {

    volatile static int sum = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            sum++;
        }
        System.out.println(sum);
    }
}
