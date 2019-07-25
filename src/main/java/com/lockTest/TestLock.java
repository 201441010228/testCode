package com.lockTest;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @Auther: 张扬
 * @Date: 2019/1/7 14:30
 * @Description:
 */
public class TestLock {

    public  static  void  main(String[] args){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0;i<100;i++){
            new Thread(new LockRunable()).start();
        }
//        int i = 0;
//        while (i < 10000) {
//            i++;
//            if (i % 100 == 0) {
//                System.out.println(i);
//            }
//        }
    }
}
