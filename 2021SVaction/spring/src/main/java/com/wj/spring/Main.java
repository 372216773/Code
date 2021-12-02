package com.wj.spring;

import com.wj.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.wj.spring");

        UserService userService = (UserService) context.getBean("userService");
        userService.save();
    }
}
