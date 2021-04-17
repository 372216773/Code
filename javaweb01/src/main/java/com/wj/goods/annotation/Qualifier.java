package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//使用范围
@Target(ElementType.FIELD)
//保留时间范围
@Retention(RetentionPolicy.RUNTIME)
/*
通过@Qualifier(“你要注入的bean的名称”)来选择注入对象
 */
public @interface Qualifier {

    String beanName();

}
