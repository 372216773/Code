package com.wj.ssm.controller;

import com.wj.ssm.entity.User;
import com.wj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findById/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user",userService.findById(id));
        return "/index.jsp";
    }

}
