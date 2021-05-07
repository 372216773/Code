package com.wj.springboot.controller;

import com.wj.springboot.entity.User;
import com.wj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController=@Controller+@ResponseBody-->结果会以json格式返回
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findById")
    public User findById(@RequestParam Integer id) {
        User user = userService.findById(id);
        System.out.println(user);
        //打印日志
        //user.slf4jMes();
        //int i=10/0;
        return user;
        //Spring Boot是可以自动将一个类转成JSON格式返回的
    }

    @RequestMapping("updateById")
    @Transactional
    //事务管理,自动提交设置为false,当方法中没有进行try/catch,之后才手动提交
    public void updateById(Integer id,String name) {
        userService.updateById(id,name);

    }

}
