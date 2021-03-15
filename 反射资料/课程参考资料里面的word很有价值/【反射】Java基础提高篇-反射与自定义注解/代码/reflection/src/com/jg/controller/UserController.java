package com.jg.controller;

import com.jg.annotation.Cache;
import com.jg.pojo.User;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 23:05
 * @Version 1.0
 */
public class UserController {

    private User[] users = {
            new User("张三", 23, "123"),
            new User("李四", 24, "234"),
            new User("王五", 25, "345"),
            new User("赵六", 26, "456"),
            new User("田七", 27, "567"),
            new User("王八", 28, "678"),
            new User("老九", 29, "789")
    };

    /**
     * 根据id获取用户
     * @param index
     * @return
     */
    @Cache(key = "user")
    public User getUserById(Integer index) {
        System.out.println("获取用户方法被调用，id为：" + index);
        return users[index];
    }

}
