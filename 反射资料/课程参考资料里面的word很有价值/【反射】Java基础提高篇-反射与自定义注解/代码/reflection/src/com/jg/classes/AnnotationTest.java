package com.jg.classes;

import com.jg.annotation.MyAnnotation;
import com.jg.controller.UserController;
import com.jg.pojo.User;
import com.jg.utils.CacheUtils;
import org.junit.Test;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:57
 * @Version 1.0
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() {
        Class<User> userClass = User.class;
        // 获取注解
        MyAnnotation myAnnotation = userClass.getAnnotation(MyAnnotation.class);
        // 注解不为空的时候进行处理
        if (myAnnotation != null) {
            // 获取打在User类上的注解的两个属性
            String name = myAnnotation.name();
            int value = myAnnotation.value();
            System.out.println(name + ":" + value);
        }
    }

    @Test
    public void testCache() throws Exception {
        UserController userController = new UserController();
//        Object user1 = method.invoke(userController, 0);
//        Object user2 = method.invoke(userController, 0);
//        System.out.println(user1);
//        System.out.println(user2);

        Object user1 = CacheUtils.invokeMethod(userController, "getUserById", 0);
        Object user2 = CacheUtils.invokeMethod(userController, "getUserById", 0);
        System.out.println(user1);
        System.out.println(user2);

    }

}
