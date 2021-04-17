package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用范围:类
@Target(ElementType.TYPE)
//保留级别:运行时
@Retention(RetentionPolicy.RUNTIME)
/*
给加了Component注解的类都交给Spring来管理,范式注解
 */
public @interface Component {
    String value();//组件名称

}
