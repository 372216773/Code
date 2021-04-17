package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用范围:属性
@Target(ElementType.FIELD)
//保留级别:运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValue {
    String value();

}
