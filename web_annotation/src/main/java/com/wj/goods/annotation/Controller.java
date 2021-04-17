package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
//保留级别:运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    String value() default "";

}
