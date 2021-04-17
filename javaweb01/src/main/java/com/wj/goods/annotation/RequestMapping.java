package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*使用范围:类与方法*/
@Target({ElementType.TYPE, ElementType.METHOD})
/*注解保留时间范围*/
@Retention(RetentionPolicy.RUNTIME)

/*
请求映射
 */
public @interface RequestMapping {
    /*完全可以这样写,看起来一目了然,但是对于使用者来说增加麻烦
     所以写的时候要考虑用户的使用体验
    String url();
    */
    String value();//请求地址
}
