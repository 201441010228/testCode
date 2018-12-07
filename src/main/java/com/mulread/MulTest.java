package com.mulread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import jdk.nashorn.internal.ir.BinaryNode;

public class MulTest {

    private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()/2,
                                                                   Runtime.getRuntime().availableProcessors(), 30,TimeUnit.MILLISECONDS, new                            ArrayBlockingQueue<Runnable>(5),
                                                                   new CustomRejectedExecutionHandler());
    private static int count = 0;

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    count++;
                    System.out.println(count);
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
        threadPoolExecutor.shutdown();
        int alive = threadPoolExecutor.getActiveCount();
        System.out.println(alive);
    }

}
