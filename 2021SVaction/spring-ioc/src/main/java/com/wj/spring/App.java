package com.wj.spring;

import com.wj.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 应用程序入口
 */
public class App {
    public static void main(String[] args) {
        //创建上下文对象基于注解
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wj.spring");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.saveUser();
    }
}
