package com.jg.classes;

import com.jg.pojo.Session;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:16
 * @Version 1.0
 */
public class ObjectTest {

    @Test
    public void testObject() {
        Session session1 = Session.get();
        Session session2 = Session.get();
        System.out.println(session1 == session2);
    }

    @Test
    public void testObject2() throws Exception {
        Session session1 = Session.get();
        Class<Session> sessionClass = Session.class;
        Constructor<Session> declaredConstructor = sessionClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Session session2 = declaredConstructor.newInstance();
        System.out.println(session2 == session1);
    }

}
