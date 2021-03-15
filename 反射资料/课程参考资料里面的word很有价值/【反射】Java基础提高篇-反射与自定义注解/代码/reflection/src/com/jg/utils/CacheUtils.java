package com.jg.utils;

import com.jg.annotation.Cache;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 杨德石
 * @Date: 2020/1/21 23:08
 * @Version 1.0
 */
public final class CacheUtils {

    /**
     * HashMap是线程不安全的，这里应该用ConcurrentHashMap
     */
    private static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    private CacheUtils() {
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
        Class<?> objClass = obj.getClass();
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

                // 获取缓存注解
                Cache cacheAnnotation = method.getAnnotation(Cache.class);
                // 先判断注解是否为空
                if (cacheAnnotation != null) {
                    // 方法有参数，以第一个参数为小key。
                    Object paramsKey = params[0];
                    // 获取大key
                    String key = cacheAnnotation.key();
                    // 拼接key
                    String cacheKey = key + "." + paramsKey;
                    // 获取缓存
                    Object cacheValue = cacheMap.get(cacheKey);
                    // 判断缓存是否存在，如果存在，直接返回缓存的值
                    if (cacheValue != null) {
                        return cacheValue;
                    }
                }
                method.setAccessible(true);
                result = method.invoke(obj, valueArr);
                // 方法执行完了，将数据放入到缓存中
                if(cacheAnnotation!=null) {
                    // 获取key
                    // 方法有参数，以第一个参数为小key。
                    Object paramsKey = params[0];
                    // 获取大key
                    String key = cacheAnnotation.key();
                    // 拼接key
                    String cacheKey = key + "." + paramsKey;
                    cacheMap.put(cacheKey, result);
                }
            } else {
                method = objClass.getDeclaredMethod(methodName);
                // 获取缓存注解
                Cache cacheAnnotation = method.getAnnotation(Cache.class);
                // 先判断注解是否为空
                if (cacheAnnotation != null) {
                    // 获取大key
                    String key = cacheAnnotation.key();
                    // 获取缓存
                    Object cacheValue = cacheMap.get(key);
                    // 判断缓存是否存在，如果存在，直接返回缓存的值
                    if (cacheValue != null) {
                        return cacheValue;
                    }
                }
                method.setAccessible(true);
                result = method.invoke(obj);
                // 方法执行完了，将数据放入到缓存中
                if(cacheAnnotation!=null) {
                    String key = cacheAnnotation.key();
                    cacheMap.put(key, result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
