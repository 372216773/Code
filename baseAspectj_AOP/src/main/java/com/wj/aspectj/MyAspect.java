package com.wj.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面
@Aspect
//交给spring管理
@Component
public class MyAspect {
    //(""任意访问修饰符 *任意返回值类型 包名.类名.以User结尾 任意参数)
    @Before("execution(* com.wj.aspectj.service.UserService.*User(..))")
    public void before() {
        System.out.println("前置通知");
    }

    @After("execution(* com.wj.aspectj.service.UserService.*User(..))")
    public void after() {
        System.out.println("后置通知");
    }

    public void around() {
        System.out.println("环绕通知");
    }
}
