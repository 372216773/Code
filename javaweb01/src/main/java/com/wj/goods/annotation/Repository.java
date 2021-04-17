package com.wj.goods.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/*
用于标注数据访问组件，即DAO组件
 */
public @interface Repository {

    String value() default "";

}
