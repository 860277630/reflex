package com.example.demo.someTest;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:06
 * @Version 1.0
 */
public class ConstructorTest {

    @Test
    public void testNewInstance() throws Exception {
        Class<User> userClass = User.class;
        // Class的newInstance方法默认只走无参构造，不够强大。
//        User user = userClass.newInstance();
//        System.out.println(user);
        Constructor<User> constructor = userClass.getConstructor();
        User user = constructor.newInstance();
        System.out.println(user);
    }

    @Test
    public void testPrivateConstructor() throws Exception {
        Class<MethodUtils> methodUtilsClass = MethodUtils.class;
        Constructor<MethodUtils> declaredConstructor = methodUtilsClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        //利用构造函数去创建
        MethodUtils methodUtils = declaredConstructor.newInstance();
        System.out.println(methodUtils.hashCode());
        MethodUtils methodUtils2 = declaredConstructor.newInstance();
        System.out.println(methodUtils2.hashCode());
    }

}
