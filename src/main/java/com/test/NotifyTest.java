package com.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: 张扬
 * @Date: 2019/6/17 15:18
 * @Description:
 */
public class NotifyTest implements Runnable{

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
           String str = "[{\"serial_number\":\"1\",\n"
                   + "  \"flight_date\":\"2017-02-06\",\n"
                   + "  \"flight_no\":\"SC8756\",\n"
                   + "  \"departure_airport\":\"FOC\",\n"
                   + "  \"arrival_airport\":\"TNA\",\n"
                   + "  \"std\":\"2017-02-06 15:30:00\",\n"
                   + "  \"atd\":\"2017-02-06 17:12:00\",\n"
                   + "  \"sta\":\"2017-02-06 17:45:00\",\n"
                   + "  \"ata\":\"2017-02-06 19:12:00\",\n"
                   + "  \"abnormal_status\":\"延误\",\n"
                   + "  \"abnormal_reason\":\"其他空域用户占用空域\",\n"
                   + "  \"cld_time\":\"2017-02-15 10:10:00\",\n"
                   + "  \"sub_flights\":[]},\n"
                   + "  {\"serial_number\":\"2\",\n"
                   + "  \"flight_date\":\"2017-02-06\",\n"
                   + "  \"flight_no\":\"SC8756\",\n"
                   + "  \"departure_airport\":\"TNA\",\n"
                   + "  \"arrival_airport\":\"URC\",\n"
                   + "  \"std\":\"2017-02-06 18:35:00\",\n"
                   + "  \"atd\":\"2017-02-06 20:12:00\",\n"
                   + "  \"sta\":\"2017-02-06 23:20:00\",\n"
                   + "  \"ata\":\"\",\n"
                   + "  \"abnormal_status\":\"备降\",\n"
                   + "  \"abnormal_reason\":\"\",\n"
                   + "  \"cld_time\":\"2017-02-15 10:10:00\",\n"
                   + "  \"sub_flights\":[{\"serial_number\":\"1\",\n"
                   + "                  \"flight_date\":\"2017-02-06\",\n"
                   + "\t\t\t\t  \"flight_no\":\"SC8756\",\n"
                   + "\t\t\t\t  \"departure_airport\":\"TNA\",\n"
                   + "\t\t\t\t  \"arrival_airport\":\"TLQ\",\n"
                   + "\t\t\t\t  \"std\":\"2017-02-06 18:45:00\",\n"
                   + "\t\t\t\t  \"atd\":\"2017-02-06 20:12:00\",\n"
                   + "\t\t\t\t  \"sta\":\"2017-02-06 23:30:00\",\n"
                   + "\t\t\t\t  \"ata\":\"2017-02-07 00:47:00\",\n"
                   + "\t\t\t\t  \"abnormal_status\":\"正常\",\n"
                   + "\t\t\t\t  \"abnormal_reason\":\"\",\n"
                   + "\t\t\t\t  \"cld_time\":\"2017-02-15 10:10:00\",\n"
                   + "\t\t\t\t  \"sub_flights\":[]},\n"
                   + "\t\t\t\t  {\"serial_number\":\"2\",\n"
                   + "\t\t\t\t  \"flight_date\":\"2017-02-06\",\n"
                   + "\t\t\t\t  \"flight_no\":\"SC8756\",\n"
                   + "\t\t\t\t  \"departure_airport\":\"TLQ\",\n"
                   + "\t\t\t\t  \"arrival_airport\":\"URC\",\n"
                   + "\t\t\t\t  \"std\":\"2017-02-07 00:00:00\",\n"
                   + "\t\t\t\t  \"atd\":\"2017-02-07 02:18:00\",\n"
                   + "\t\t\t\t  \"sta\":\"2017-02-07 01:00:00\",\n"
                   + "\t\t\t\t  \"ata\":\"\",\"abnormal_status\":\"备降\",\n"
                   + "\t\t\t\t  \"abnormal_reason\":\"\",\n"
                   + "\t\t\t\t  \"cld_time\":\"2017-02-15 10:10:00\",\n"
                   + "\t\t\t\t  \"sub_flights\":[]}]}]\n";

    }

    @Override
    public void run() {
        System.out.println(1);
        System.out.println(2);
        synchronized (atomicInteger) {
            try {
                atomicInteger.notifyAll();
                atomicInteger.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(3);
        System.out.println(4);
    }
}
