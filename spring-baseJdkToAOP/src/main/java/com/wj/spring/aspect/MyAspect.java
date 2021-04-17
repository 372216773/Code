package com.wj.spring.aspect;

//切面
public class MyAspect {
    public void before() {
        System.out.println("前置通知-------------");
    }
    public void after() {
        System.out.println("后置通知-------------");
    }
    public void around() {
        System.out.println("环绕通知-------------");
    }
}
