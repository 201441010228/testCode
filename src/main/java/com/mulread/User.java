package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2018/7/23 14:26
 * @Description:
 */

public class User {

    private  String name;
    private  Integer age;
    private  Double score;


    public User() {
    }

    public User(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
