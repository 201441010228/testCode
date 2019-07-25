package com.lockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 张扬
 * @Date: 2019/1/7 14:23
 * @Description:
 */
public class LockRunable implements Runnable {

    private Lock lock = new ReentrantLock();
    private static int count = 0;

    @Override
    public void run() {
       lock.lock();
            for (int i = 0; i < 100; i++) {
                count++;
            }
       lock.unlock();
        System.out.println(count);
    }
}
