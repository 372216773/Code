package annotation;

import java.lang.annotation.Annotation;

public class TestDemo{
    public static void main(String[] args) {
        //获取类对象
        Class demoClass = Demo.class;

        //获取类对象的所有注解
        Annotation[] annotations = demoClass.getAnnotations();

        //
        
    }
}
