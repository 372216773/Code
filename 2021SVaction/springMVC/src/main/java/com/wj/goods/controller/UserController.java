package com.wj.goods.controller;

import com.wj.goods.entity.User;
import com.wj.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/login")
    //按照 get/set 注入
    @ResponseBody
    //以响应实体的形式返回,不进行转发(相当于fastJson的作用)
    public User login(@RequestBody() User user)  {
        System.out.println(user);
        return user;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public User findById(@RequestParam(value = "id", required = false,defaultValue = "000") Integer id) {
        User user = new User(id,"admin","123");
        return user;
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public User findByName(@RequestParam("name") String name) {
        User user = new User(01,name,"234");
        return user;
    }


}