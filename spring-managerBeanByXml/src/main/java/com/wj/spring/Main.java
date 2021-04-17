package com.wj.spring;

import com.wj.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //配置扫描路径
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wj.spring");
        UserService userService = (UserService) applicationContext.getBean("renameService");
        userService.save();
    }
}
