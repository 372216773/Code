package com.wj.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HttpServletRequest对象:   ");
        System.out.println("会话对象(Session):  " + req.getSession().getId());
        System.out.println("请求方式:  " + req.getMethod());
        System.out.println("请求协议:  " + req.getProtocol());
        //设置读取客户端请求数据的编码
        req.setCharacterEncoding("utf8");
        System.out.println("统一资源定义符(url):  " + req.getRequestURL());
        System.out.println("统一资源标识符(uri):  " + req.getRequestURI());
        System.out.println("参数name:   " + req.getParameter("name"));
        System.out.println("参数password:   " + req.getParameter("password"));
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(req.getHeader(headerNames.nextElement()));
        }

        System.out.println("通过getParameterMap获取到参数信息:   ");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry);
        }

        System.out.println("HttpServletResponse对象");
        System.out.println("status: " + resp.getStatus());

        //设置状态码
        //resp.setStatus(200);

        //设置响应头信息
        resp.setHeader("header1", "admin");
        resp.setHeader("header2", "admin");

        //指定服务器响应给浏览器的编码。
        resp.setCharacterEncoding("gbk");

        //指定服务器响应给浏览器的编码
        resp.setCharacterEncoding("gbk");
        /*
        1. pageEncoding=”UTF-8”的作用是设置JSP编译成Servlet时使用的编码。
        2. contentType=”text/html;charset=UTF-8”的作用是指定服务器响应给浏览器的编码。
        setCharacterEncoding作用是告诉servlet用utf-8转码，而不是用默认的iso8859-1
        */

        //设置响应实体
        //空格算一个字符
        resp.getWriter().print("Hello Servlet,你好");

        //路径信息
        System.out.println("两个路径信息: ");
        //返回具体的servlet的路径
        System.out.println("getServletPath: " + req.getServletPath());
        //返回上下文的路径
        System.out.println("getContextPath: " + req.getContextPath());

        //获取上下文对象,代表当前应用程序
        System.out.println("上下文对象:  ");
        ServletContext servletContext = req.getServletContext();
        System.out.println("通过上下文对象获取ContextPath:    " + servletContext.getContextPath());
        System.out.println("通过上下文对象获取ContextName:   " + servletContext.getServletContextName());
        System.out.println("通过上下文对象获取RealPath:  " + servletContext.getRealPath("/hello"));
    }
}
/*

 */
