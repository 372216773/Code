package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
//保留级别:运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {
    String value();//sql语句

}
