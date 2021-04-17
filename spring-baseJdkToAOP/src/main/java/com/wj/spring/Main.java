package com.wj.spring;

import com.wj.spring.service.UserService;
import com.wj.spring.service.UserServiceFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //创建代理类工厂
        UserServiceFactory factory = new UserServiceFactory();
        //拿到委托类
        UserService userService = factory.newUserServiceProxy();
        userService.addUser();
        userService.deleteUser();
    }
}
