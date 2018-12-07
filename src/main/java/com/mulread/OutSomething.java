package com.mulread;


public class OutSomething implements Runnable {



    private static int count = 0;
    private  Object lock = new Object();
    private String name;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " 运行" + i);
            System.out.println(name + "运行   " + "总计累加 "+ ++count + "次");
            try {
               Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
    }


    public OutSomething(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
