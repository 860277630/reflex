package com.example.demo.someTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import jdk.nashorn.internal.runtime.logging.Logger;

public class myTest_1 {


    //获取class的方式
    @Test
    public void test_1() throws ClassNotFoundException {
        //获取class方法1
        Class<User> userClass = User.class;
        System.out.println(userClass);

        //获取class方法2
        Class<?> aClass = Class.forName("com.example.demo.someTest.User");
        System.out.println(aClass);

        //获取class方式3
        User user = new User();
        Class<? extends User> aClass1 = user.getClass();
        System.out.println(aClass1);
    }


    //反射常用的方法
    @Test
    public void test_2() throws IllegalAccessException, InstantiationException {
        Class<User> userClass = User.class;
        //获取包名  有个package前缀
        System.out.println(userClass.getPackage());
        //获取类，字段，方法等的名称
        System.out.println(userClass.getName());
        //获取不带包的类名
        System.out.println(userClass.getSimpleName());

        //对class进行实例化
        User user = userClass.newInstance();
        System.out.println(user.toString());

        //获取类加载器
        ClassLoader classLoader = userClass.getClassLoader();

        //获取该类中的公共类和接口
        Class<?>[] classes = userClass.getClasses();
        for (Class<?> aClass : classes) {
            System.out.println(aClass);
        }
        //获取所有的类和接口
        Class<?>[] declaredClasses = userClass.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println(declaredClass);
        }
    }

    //反射对接口父类等的一系列操作
    @Test
    public void test_3() {
        Class<User> userClass = User.class;
        // 获取当前类继承的父类的名字
        Class<? super User> superclass = userClass.getSuperclass();
        System.out.println(superclass.getName());
        // 获取当前类实现的接口。注意：Java中一个类可以实现多个接口，所以这里是数组
        Class<?>[] interfaces = userClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        // 将该类转换为父类。
        Class<? extends Animal> chineseClass = superclass.asSubclass(Animal.class);
        System.out.println(chineseClass.getName());


    }


    //获取类中字段相关方法
    @Test
    public void test_4() throws NoSuchFieldException {
        Class<User> userClass = User.class;
        // getFields：获取所有的公共字段
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        // 根据名称去获取公共字段
        Field idNumber = userClass.getField("idNumber");
        System.out.println(idNumber.getName());
        // 获取全部的字段，包括私有字段
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        // 根据名称去获取字段
        Field age = userClass.getDeclaredField("age");
        System.out.println(age.getName());
    }

    //获取注解
    @Test
    public void test_5() {
        Class<User> userClass = User.class;
        // 根据注解的class，去获取指定类/方法/字段上的注解
        Logger loggerAnnotation = userClass.getAnnotation(Logger.class);
        if (loggerAnnotation == null) {
            System.out.println("没有logger注解，你不能输出日志");
        } else {
            System.out.println(loggerAnnotation.name() + "进行日志输出");
        }
    }

    //获取构造器和方法
    @Test
    public void test_6() throws NoSuchMethodException {
        Class<User> userClass = User.class;
        // 获取所有的公共构造方法
        Constructor<?>[] constructors = userClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("输出构造方法参数：");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class parameter : parameterTypes) {
                System.out.print(parameter.getName() + ",");
            }
            System.out.println("构造方法参数输出完毕");
        }


        // 根据参数类型获取公共构造方法，参数就是类型的class
        // ...表示不定长参数，不定长参数可以传多个，也可以不传递。
        Constructor<User> constructor = userClass.getConstructor(String.class, Integer.class, String.class);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }
    }

    //获取类中的方法
    @Test
    public void test_7() {
        Class<User> userClass = User.class;
        // 判断当前class是否是注解
        System.out.println("User调用isAnnotation方法：" + userClass.isAnnotation());
        Class<Logger> loggerClass = Logger.class;
        System.out.println("Logger调用isAnnotation方法：" + loggerClass.isAnnotation());
        // 判断当前class是否包含指定注解
        System.out.println("User调用isAnnotationPresent方法：" + userClass.isAnnotationPresent(Logger.class));

        Class<MyInterface> myInterfaceClass = MyInterface.class;
        System.out.println("MyInterface调用isInterface方法：" + myInterfaceClass.isInterface());

        // 获取所有的构造方法（包括私有构造方法）
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("输出构造方法参数：");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class parameter : parameterTypes) {
                System.out.print(parameter.getName() + ",");
            }
            System.out.println("构造方法参数输出完毕");
        }
    }

}
