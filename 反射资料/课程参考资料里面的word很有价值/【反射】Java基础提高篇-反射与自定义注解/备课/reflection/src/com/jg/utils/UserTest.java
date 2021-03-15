package com.jg.utils;

/**
 * @Author: 杨德石
 * @Date: 2020/1/16 21:53
 * @Version 1.0
 */
public class UserTest {

    public static void main(String[] args) {
        User user = new User();
        Object toString = ReflectionUtils.invokeMethodByName(user, "toString", null);
        System.out.println(toString);
    }

}
