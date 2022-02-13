package com.wj.springweb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 */
@Aspect
//标注为切面
@Component
//交给spring管理
public class MyAspect {

    @Before("execution(* com.wj.springweb.service.UserService.*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    public void after() {
        System.out.println("后置通知");
    }

    public void around() {
        System.out.println("环绕通知");
    }
}
