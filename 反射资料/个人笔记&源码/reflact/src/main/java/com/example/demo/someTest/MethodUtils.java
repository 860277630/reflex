package com.example.demo.someTest;

import java.lang.reflect.Method;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 21:46
 * @Version 1.0
 */
public final class MethodUtils {

    private MethodUtils() {
    }

    /**
     * 执行当前指定对象的指定方法
     *
     * @param obj
     * @param methodName
     * @param params
     * @return
     */
    public static Object invokeMethod(Object obj, String methodName, Object... params) {
        long startTime = System.currentTimeMillis();
        Class<?> objClass = obj.getClass();
        System.out.println("执行类：" + objClass.getName());
        System.out.println("方法：" + methodName);
        System.out.println("参数：" + params);
        Object result = null;
        try {
            Method method;
            if (params.length > 0) {
                Class<?>[] classArr = new Class[params.length];
                Object[] valueArr = new Object[params.length];
                for (int i = 0; i < params.length; i++) {
                    classArr[i] = params[i].getClass();
                    valueArr[i] = params[i];
                }
                method = objClass.getDeclaredMethod(methodName, classArr);
                method.setAccessible(true);
                result = method.invoke(obj, valueArr);
            } else {
                method = objClass.getDeclaredMethod(methodName);
                method.setAccessible(true);
                result = method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("返回值：" + result);
        System.out.println("执行时间：" + (endTime - startTime));
        return result;
    }

    @Override
    public String toString() {
        return "toString方法执行了。。。";
    }
}
