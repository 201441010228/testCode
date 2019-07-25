package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2019/7/10 17:22
 * @Description:
 */
public class TestRunable implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while(count++<100){
            System.out.println(Thread.currentThread().getName()+"我睡着了"+count);
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
