package com.example.demo.someTest;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.math.BigDecimal;

@Logger
public class User extends Animal implements MyInterface{
    private String name;
    protected  Integer age;
    public String idNumber;

    public User() {
    }

    protected User(String name, Integer age, String idNumber) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
    }


    private User(String name) {
        this.name = name;
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
