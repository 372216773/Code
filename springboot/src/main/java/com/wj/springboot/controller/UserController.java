package com.wj.springboot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.wj.springboot.entity.User;
import com.wj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DataSource druidDataSource;

    @RequestMapping("/findById")
    public User findById(@RequestParam String id) {
        System.out.println(druidDataSource);
        return userService.findById(id);
    }

}
