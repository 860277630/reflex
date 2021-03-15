package com.jg.pojo;

import com.jg.annotation.MyAnnotation;

import java.math.BigDecimal;

/**
 * @Author: 杨德石
 * @Date: 2020/1/20 22:37
 * @Version 1.0
 */
@MyAnnotation(123)
public class User extends Animal implements MyInterface {

    private String name;
    protected Integer age;
    public String idNumber;

    public User() {
    }

    private User(String name) {
        this.name = name;
    }

    public User(String name, Integer age, String idNumber) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Integer getAge() {
        return age;
    }

    protected void setAge(Integer age) {
        this.age = age;
    }

    private String getIdNumber() {
        return idNumber;
    }

    private void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public void method1() {
        System.out.println("方法1的实现");
    }

    public void setNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static class Bike {

        private BigDecimal price;

    }

    private static class Clothes {

        private BigDecimal price;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
