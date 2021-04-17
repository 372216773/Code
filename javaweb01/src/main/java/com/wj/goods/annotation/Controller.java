package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*描述注解的使用范围*/
/*TYPE:类*/
@Target(ElementType.TYPE)
/*描述注解保留的时间范围(被描述的注解在它所修饰的类中可以被保留到何时)*/
/*RUNTIME:运行期保留*/
@Retention(RetentionPolicy.RUNTIME)
/*
标识一个该类是Spring MVC controller处理器，用来创建处理http请求的对象.
 */
public @interface Controller {

    String value() default "";

}
