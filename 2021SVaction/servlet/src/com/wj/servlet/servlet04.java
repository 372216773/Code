package com.wj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>我现在到:" + req.getContextPath() + req.getServletPath() + "了"+"</h3>");
        System.out.println("我现在在servlet4中做事情......");
        req.setAttribute("id","123");
    }
}
