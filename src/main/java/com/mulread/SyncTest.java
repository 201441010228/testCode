package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2019/6/5 14:38
 * @Description:
 */
public class SyncTest implements Runnable {

    private static volatile  SyncTest syncTest = null;
    private static Object o ;

    public  void haha(){
        synchronized (SyncTest.class) {
            System.out.println("haha");
        }
    }

    public void hehe(){
        System.out.println("hehe");
    }

    @Override
    public void run() {
        haha();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hehe();
    }

    public static SyncTest getInstance(){
        if (syncTest == null){
            synchronized (SyncTest.class){
                syncTest = new SyncTest();
            }
        }
        return syncTest;
    }


}
