package com.wj.springboot.controller;

import com.wj.springboot.entity.User;
import com.wj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findById")
    public User findById(@RequestParam Integer id) {
        User user = new User(1,"wj",23);
        user.slf4jMes();
        return user;
        //Spring Boot是可以自动将一个类转成JSON格式返回的

    }

}
