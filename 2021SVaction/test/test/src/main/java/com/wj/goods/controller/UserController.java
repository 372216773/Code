package com.wj.goods.controller;

import com.wj.goods.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
//映射路径(父)
//或者直接在方法上写全路径,不用分开,都可以
public class UserController {

    @RequestMapping("/login")
    //按照 get/set 注入
    public ModelAndView login(@RequestBody User user) throws ServletException, IOException {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("/login.jsp");
        return modelAndView;
    }
}