package com.mulread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 张扬
 * @Date: 2018/7/26 13:56
 * @Description:
 */
public class VolatileTest {

    // public int inc = 0;
    public AtomicInteger inc = new AtomicInteger();
    private Lock lock = new ReentrantLock();
    public  static  void  main(String args[]){
        final VolatileTest volatileTest = new VolatileTest();
        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j<1000;j++){
                        volatileTest.increase();
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(volatileTest.inc);

    }

    private  void increase(){
      inc.getAndIncrement();
    }

}
