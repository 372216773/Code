package com.wj.spring.controller;


//设置了@WebServlet注解,当请求该Servlet时,服务器就会自动读取当中的信息
//@WebServlet("/user.do")
//继承HttpServlet,重写service方法来处理请求


import com.wj.spring.entity.User;
import com.wj.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

//url匹配方法
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    /*通过get,set方法注入的,没有使用反射,不能访问私有属性*/
    public void login(@RequestBody User user) {
        System.out.println(user);

    }

}
