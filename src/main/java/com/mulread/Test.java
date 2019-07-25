package com.mulread;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: 张扬
 * @Date: 2019/6/5 14:44
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LocalDate localDate = LocalDate.now();
        LocalDate newLocalDate = localDate.plusDays(2);
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(instant);
        Instant newinstant = newLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date to = Date.from(newinstant);

        List<User> list = new ArrayList<>();
        User u1 = new User(11 ,from);
        User u2 = new User(12,from);
        User u3 = new User(12,to);
        User u4 = new User(11,to);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.sort(Comparator.comparing(User::getAge).reversed().thenComparing(User::getDate).reversed());
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    static  class  User{
       private int age;
       private Date date;
       User(){
       }
    }

}
