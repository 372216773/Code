package com.wj.aspectj;

import com.wj.aspectj.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userServiceImpl = (UserService) xmlApplicationContext.getBean("userService");

        userServiceImpl.deleteUser();
        userServiceImpl.addUser();
    }
}
