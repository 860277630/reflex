package com.jg.classes;

import com.jg.pojo.Animal;
import com.jg.pojo.MyInterface;
import com.jg.pojo.User;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: 杨德石
 * @Date: 2020/1/20 22:41
 * @Version 1.0
 */
public class ClassesTest {

    /**
     * 类操作1
     */
    @Test
    public void testClass() {
        // 通过类名.class获取class
        Class<User> userClass = User.class;
        // class.getName() 获取类完成包名 com.jg.pojo.User
//        System.out.println(userClass.getName());
        // class.getClasses：获取该类下的所有公共类和接口
        Class<?>[] classes = userClass.getClasses();
        for (Class<?> clazz : classes) {
//            System.out.println(clazz.getName());
        }
        // getDeclaredClasses：获取该类中所有类和接口，不管权限修饰符
        Class<?>[] declaredClasses = userClass.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
//            System.out.println(declaredClass.getName());
        }

        try {
            // 通过Class.forName("类全路径") 可以去加载指定的类 加载JDBC驱动的时候
            Class<?> aClass = Class.forName("com.jg.pojo.User");
//            Object o = aClass.newInstance();
//            User u = (User) o;
//            System.out.println(u);
//            System.out.println(aClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取类所在的包。注意：这里获取到的包名。这个包名前面有个package 前缀，如果需要对包名进行操作，记得把前缀去掉
//        System.out.println(userClass.getPackage());
        // 获取类名，不带包名
//        System.out.println(userClass.getSimpleName());
        try {
            // newInstance：创建类的实例。
            User user = userClass.newInstance();
//            user.setName("张三");
//            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 演示多态操作
     */
    @Test
    public void testExtends() {
        Class<User> userClass = User.class;
        // 获取当前类继承的父类的名字
        Class<? super User> superclass = userClass.getSuperclass();
//        System.out.println(superclass.getName());
        // 获取当前类实现的接口。注意：Java中一个类可以实现多个接口，所以这里是数组
        Class<?>[] interfaces = userClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
//            System.out.println(anInterface.getName());
        }
        // 将该类转换为父类。
        Class<? extends Animal> chineseClass = superclass.asSubclass(Animal.class);
//        System.out.println(chineseClass.getName());

        /*
        Java中父类对象是否可以转换为子类对象？
        回答：
         1.在java中，子类对象可以直接转换为父类对象，但是父类对象不能 直接 转换为子类对象
         2.当当前的对象确定是某个子类的对象时，那么就可以将这个父类引用转换为对应的子类对象
         3.当需求中一定要将父类对象转换为子类对象时应该怎么办？
            |- 使用Spring的BeanUtils.copyProperties去拷贝两个对象的属性
            |- 使用JSON，将父类对象转换为JSON字符串，再将这个字符串转换为子类对象。
            注意：这两种方式严格来说并不叫“转换”，只是为了解决上面问题的两种解决方案。
         */
//        User user = new User();
//        ChineseUser chineseUser = (ChineseUser) user;
//        System.out.println(chineseUser.getName());
//        User user = new ChineseUser();
//        ChineseUser chineseUser = (ChineseUser) user;
//        System.out.println(chineseUser.getName());
    }

    @Test
    public void testClassField() throws Exception {
        Class<User> userClass = User.class;
        // getFields：获取所有的公共字段
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
//            System.out.println(field.getName());
        }
        // 根据名称去获取公共字段
        Field idNumber = userClass.getField("idNumber");
//        System.out.println(idNumber.getName());
        // 获取全部的字段，包括私有字段
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
        }
        // 根据名称去获取字段
        Field age = userClass.getDeclaredField("age");
        System.out.println(age.getName());

    }

    @Test
    public void testClassConstructor1() {
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
    }

    @Test
    public void testClassConstructor2() throws Exception {
        Class<User> userClass = User.class;
        // 根据参数类型获取公共构造方法，参数就是类型的class
        // ...表示不定长参数，不定长参数可以传多个，也可以不传递。
        Constructor<User> constructor = userClass.getConstructor(String.class, Integer.class, String.class);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }
    }

    @Test
    public void testClassConstructor3() {
        Class<User> userClass = User.class;
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

    @Test
    public void testAnnotation() {
        Class<User> userClass = User.class;
        // 根据注解的class，去获取指定类/方法/字段上的注解
        Logger loggerAnnotation = userClass.getAnnotation(Logger.class);
        if (loggerAnnotation == null) {
            System.out.println("没有logger注解，你不能输出日志");
        } else {
            System.out.println("进行日志输出");
        }
    }

    @Test
    public void testClassOtherMethod() {
        Class<User> userClass = User.class;
        // 判断当前class是否是注解
        System.out.println("User调用isAnnotation方法：" + userClass.isAnnotation());
        Class<Logger> loggerClass = Logger.class;
        System.out.println("Logger调用isAnnotation方法：" + loggerClass.isAnnotation());
        // 判断当前class是否包含指定注解
        System.out.println("User调用isAnnotationPresent方法：" + userClass.isAnnotationPresent(Logger.class));

        Class<MyInterface> myInterfaceClass = MyInterface.class;
        System.out.println("MyInterface调用isInterface方法：" + myInterfaceClass.isInterface());

    }

    @Test
    public void testObject() {
        Object obj = new User();
        Class<?> objClass = obj.getClass();
        System.out.println(objClass.getName());
    }

}
