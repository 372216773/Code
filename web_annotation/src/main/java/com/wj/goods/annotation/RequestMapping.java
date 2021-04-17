package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用范围:类
@Target({ElementType.TYPE,ElementType.METHOD})
//保留级别:运行时
@Retention(RetentionPolicy.RUNTIME)
/*
    请求映射
 */
public @interface RequestMapping {
    String value();//

}
