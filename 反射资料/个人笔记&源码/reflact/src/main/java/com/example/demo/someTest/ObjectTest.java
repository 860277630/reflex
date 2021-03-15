package com.example.demo.someTest;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:16
 * @Version 1.0
 */
public class ObjectTest {

    //construct破坏单例模式测试
    @Test
    public void testObject2() throws Exception {
        Session session11 = Session.get();
        Session session22 = Session.get();
        //==  是比较地址的
        System.out.println(session11 == session22);
        Session session1 = Session.get();
        Class<Session> sessionClass = Session.class;
        Constructor<Session> declaredConstructor = sessionClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Session session2 = declaredConstructor.newInstance();
        //==  是比较地址的
        System.out.println(session2 == session1);
    }

}
