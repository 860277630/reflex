package com.jg.classes;

import com.jg.pojo.User;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 22:25
 * @Version 1.0
 */
public class DemoTest {

    /**
     * 通过反射，可以避开泛型检查，向集合中强制添加非指定泛型的数据
     * 这种情况下，当我们遍历这个集合时，就会发生类型转换异常
     * 因此，当操作一个泛型类时，如果需要对其数据进行改变
     * 一定要只按照对应的泛型去操作。
     * 如果一定要对泛型类的数据强制改变，那么，建议后面对这个类的实例不进行任何操作
     *
     * 场景：在aop中，执行完方法获取到返回值，可能会需要对里面的数据进行改变
     * 这个时候方法已经执行完了，并且返回值也拿到了，可以对返回值进行处理
     * 处理完之后直接返回给前端
     *
     * @throws Exception
     */
    @Test
    public void testList() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 23, "123"));
        userList.add(new User("李四", 24, "234"));

        Class<? extends List> listClass = userList.getClass();
        Method getMethod = listClass.getDeclaredMethod("add", Object.class);
        getMethod.invoke(userList, 123);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
