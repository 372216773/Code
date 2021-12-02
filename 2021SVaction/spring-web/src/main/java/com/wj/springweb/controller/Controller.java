package com.wj.springweb.controller;

import com.wj.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class Controller extends HttpServlet {
    //spring 的容器并没有启动, 加载扫描都没有启动(即ApplicationContext),所以需要监听 servlet 的初始化来启动spring 容器
    @Autowired
    private UserService userService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        this.userService = webApplicationContext.getBean(UserService.class);
        System.out.println("请求进来了!");
        this.userService.add();
    }
}
