package com.example.demo.someTest;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:14
 * @Version 1.0
 */
public class Session {

    private static Session session;

    private Session() {

    }

    public synchronized static Session get() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }
}
