package com.mulread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Auther: 张扬
 * @Date: 2018/7/24 14:23
 * @Description:
 */
public class ThreadExcutor {

    //是否正在运行
    private volatile boolean RUNNING = true;

    //阻塞队列
    private static BlockingQueue<Runnable> blockingQueue = null;

    //任务集合
    private final Set<Worker> set = new HashSet<Worker>();

    //线程集合
    private final List<Thread> list = new ArrayList<Thread>();

    //线程池大小
    int poolSize = 0;

    //剩余的线程
    int coreSize = 0;

    boolean shutdown = false;

    public ThreadExcutor(int poolSize) {
        this.poolSize = poolSize;
        blockingQueue = new LinkedBlockingDeque<Runnable>(poolSize);
    }


    //执行线程
    public void exec(Runnable runnable) {
        if (null == runnable) {
            throw new NullPointerException();
        }
        if (coreSize < poolSize) {
            System.out.println("我干活了");
            addThread(runnable);
            System.out.println("目前队列中size大小:"+blockingQueue.size());
        } else {
            try {
                System.out.println("我进来排队了");
                blockingQueue.put(runnable);
                System.out.println("排队中队列大小是:"+blockingQueue.size());
            } catch (InterruptedException e) {
                System.out.println("阻塞队列加入人物异常");
            }
        }
    }

    //添加线程
    private void addThread(Runnable runnable) {
        coreSize++;
        Worker worker = new Worker(runnable);
        set.add(worker);
        Thread thread = new Thread(worker);
        list.add(thread);
        try {
            thread.start();
        } catch (Exception e) {
            System.out.println("执行线程" + thread.getName() + "失败," + "失败原因:" + e.getMessage());
        }
    }

    //终止线程
    public void shutDownThread() {
        RUNNING = false;
        if (!set.isEmpty()) {
            for (Worker worker : set) {
                worker.interruptedIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            blockingQueue.offer(runnable);
        }

        @Override
        public void run() {
            while (true && RUNNING) {
                if (true == shutdown) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("获取任务失败");
                }
            }
        }

        private Runnable getTask() throws InterruptedException {
            return blockingQueue.take();
        }

        public void interruptedIfIdle() {
            for (Thread thread : list) {
                System.out.println(thread.getName() + "线程被中断111");
            }
        }
    }
}
