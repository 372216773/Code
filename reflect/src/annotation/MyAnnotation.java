package annotation;


import java.lang.annotation.*;

////是否生成文档
//@Documented
//
////是否能被继承
//@Inherited
//
////注解的最后保留级别(在哪个级别有用) SOURCE:源码级别 CLASS:字节码级别 RunTime:运行时级别(级别最高)
//@Retention(RetentionPolicy.SOURCE)
//
////注解作用的目标 TYPE:类 PARAMETER:属性 FIELD:字段 METHOD:方法
//@Target({ElementType.TYPE,ElementType.PARAMETER,ElementType.FIELD,ElementType.METHOD})


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

//默认继承Annotation,注解本质上是接口
public @interface MyAnnotation {

    //注解的属性: public abstract默认类型,像抽象方法
    //如果属性名字为value,并且只有一个属性时,则使用注解的时候可以省略
    //@MyAnnotation(value = "hello")-->@MyAnnotation("hello")
    String value();

//    String value1();
//
//    //注解的属性可以有默认值,则使用注解的时候可以不必传递注解的属性
//    //不传值的时候为默认值,传值的话值就会改变女
//    String value2() default "hello000";
//
//    //注解的属性是数组类型的时候,我们使用注解的时候如果只想传递一个值,则可以省略数组的大括号
//    String[] ages();
}
