package com.jg.classes;

import com.jg.pojo.User;
import com.jg.utils.MethodUtils;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 21:33
 * @Version 1.0
 */
public class MethodTest {

    @Test
    public void testMethodName() {
        Class<User> userClass = User.class;
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }

    @Test
    public void testInvokeGetMethod() throws Exception {
        User user = new User("张三", 23, "220202202002022222");
        Class<? extends User> userClass = user.getClass();
        Method method = userClass.getDeclaredMethod("getIdNumber");
        method.setAccessible(true);
        // 执行指定的方法。第一个参数是要执行的哪个对象。后面的参数全部是方法参数
        Object result = method.invoke(user);
        System.out.println(result);
    }

    @Test
    public void testInvokeSetMethod() throws Exception {
        User user = new User("张三", 23, "220202202002022222");
        System.out.println("反射前：" + user);
        Class<? extends User> userClass = user.getClass();
        Method method = userClass.getDeclaredMethod("setIdNumber", String.class);
        method.setAccessible(true);
        // 执行指定的方法。第一个参数是要执行的哪个对象。后面的参数全部是方法参数
        Object result = method.invoke(user, "123456");
        System.out.println(result);
        System.out.println("反射后：" + user);
    }

    @Test
    public void testInvokeUtils() {
        User user = new User("张三", 23, "220202202002022222");
        MethodUtils.invokeMethod(user, "setNameAndAge", "李四", 24);
        System.out.println(user);
    }
}
