package com.wj.goods.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/*
给加了@Component注解的类都让spring来管理
*/
/*
Component泛指各种组件，就是说当我们的类不属于各种归类的时候
(不属于@Controller、@Services等的时候),
我们就可以使用@Component来标注这个类.
泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
 */
public @interface Component {
    //如果没有添加属性,默认是空字符串
    String value() default "";//组件名称
}
