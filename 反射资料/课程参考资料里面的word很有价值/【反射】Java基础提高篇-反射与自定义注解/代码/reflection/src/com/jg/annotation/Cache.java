package com.jg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 缓存注解
 * @Author: 杨德石
 * @Date: 2020/1/21 23:02
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    /**
     * 缓存的key
     * @return
     */
    String key();

    /**
     * 缓存时间
     */
    long cacheTime() default 10;

    /**
     * 缓存时间单位
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;


}
