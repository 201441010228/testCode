package com.io;

/**
 * @Auther: 张扬
 * @Date: 2018/7/25 18:18
 * @Description:
 */
public class VolidateTest {
    private static  int core = Runtime.getRuntime().availableProcessors() *  4;
    public static  void  main(String[] args){

//        ExecutorService executorService = Executors.newFixedThreadPool(core);
//
//        for (int i = 1;i<=5;i++){
//            executorService.execute(new AddClass());
//        }
//        executorService.shutdown();
String sunscribe = "car_fact_order:1_50||2_50";
        System.out.println(sunscribe.split(":")[0]);
        System.out.println(sunscribe.split(":")[1]);
    }

}
