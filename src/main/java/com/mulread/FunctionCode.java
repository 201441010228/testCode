package com.mulread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @Auther: 张扬
 * @Date: 2018/7/23 14:25
 * @Description:
 */
public class FunctionCode {

    public static void main(){
        List<User> users = new ArrayList<User>();
        User u1 = new User("xiaoming",1,12D);
        User u2 = new User("xiaohong", 2, 12D);
        User u3 = new User("xiaoming",1,12D);
        users.add(u1);
        users.add(u2);
        users.add(u3);
//        Map<Integer,User> map = users.stream().
//                collect(Collectors.toMap(User::getAge, Function
//                        .identity()));
    }

}
