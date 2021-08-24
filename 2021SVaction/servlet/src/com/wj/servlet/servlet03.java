package com.wj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Integer.parseInt(req.getParameter("id")) % 2 == 0) {
            resp.setStatus(302);
            //resp.setHeader("Location", req.getContextPath()+"/servlet04");
            resp.sendRedirect(req.getContextPath()+"/servlet04");
        }
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>我现在在:" + req.getContextPath() + req.getServletPath() + "</h3>");
        System.out.println(req.getAttribute("name"));
    }
}
