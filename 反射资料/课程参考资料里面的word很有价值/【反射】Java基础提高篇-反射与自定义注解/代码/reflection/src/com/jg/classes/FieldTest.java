package com.jg.classes;

import com.jg.pojo.User;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 21:16
 * @Version 1.0
 */
public class FieldTest {

    @Test
    public void testGet() throws Exception {
        User user = new User("张三", 23, "220202202002022222");
        User user1 = new User("李四", 24, "123456");
        Class<? extends User> userClass = user.getClass();
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            // setAccessible：忽略访问权限修饰符，暴力反射。
            field.setAccessible(true);
            // get方法：获取到当前对象当前字段的值。注意：参数一定要传当前对象
            System.out.println(field.getName() + ":" + field.get(user1));
        }
    }

    @Test
    public void testSet() throws Exception {
        User user = new User("张三", 23, "220202202002022222");
        System.out.println("反射前：" + user);
        Class<? extends User> userClass = user.getClass();
        Field idNumberField = userClass.getField("idNumber");
        // set方法：给对象的字段设置值。注意：obj一定要传递当前参数
        idNumberField.set(user, "123456");
        System.out.println("反射后：" + user);

        Field nameField = userClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(user, "李四");
        System.out.println("再次反射后：" + user);

    }

    @Test
    public void testAnnotation() throws Exception {
        Class<User> userClass = User.class;
        Field idNumberField = userClass.getField("idNumber");
        // 只要是反射的类，都有getAnnotation这个方法，可以去获取对应区域的注解
        Deprecated deprecated = idNumberField.getAnnotation(Deprecated.class);
        System.out.println(deprecated);
    }

}
