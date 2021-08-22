package com.wj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        req.setAttribute("my","Mai");
        System.out.println("servlet01......" + name);
        req.getServletContext().setAttribute("contextParam","13");
        System.out.println(req.getServletContext().getAttribute("contextParam"));
        //ctrl+p提示信息
        //内部转发,在web.xml中注册的路径
        req.getRequestDispatcher("/servlet02").forward(req, resp);
    }
}
