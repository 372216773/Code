package com.wj.ssm.controller;


import com.wj.ssm.entity.User;
import com.wj.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserController {

    @Autowired
    UserService userService;

    @Test
    public void TestUserController() {
        User user = userService.findById(1);
        System.out.println(user);

    }

}
