package com.wj.servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class HelloServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("======================================================================================");

        System.out.println("HttpServletRequest对象:   ");
        System.out.println("会话对象(Session):  " + req.getSession().getId());
        System.out.println("请求方式(getMethod()):  " + req.getMethod());
        System.out.println("请求协议(getProtocol()):  " + req.getProtocol());
        //获取
        System.out.println("当前服务器的端口"+req.getLocalPort());
        System.out.println("远程客户端的地址(主机+端口)"+req.getRemoteHost()+":"+req.getRemotePort());
        //设置读取客户端请求数据的编码
        req.setCharacterEncoding("utf8");
        System.out.println("统一资源定义符(getRequestURL()):  " + req.getRequestURL());
        System.out.println("统一资源标识符(getRequestURI()):  " + req.getRequestURI());
        System.out.println("参数(getParameter())name:   " + req.getParameter("name"));
        System.out.println("参数(getParameter())password:   " + req.getParameter("password"));
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(req.getHeader(headerNames.nextElement()));
        }

        System.out.println("通过getParameterMap获取请求头信息:   ");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry);
        }

        System.out.println("======================================================================================");

        System.out.println("HttpServletResponse对象");
        System.out.println("status: " + resp.getStatus());

        //路径信息
        System.out.println("两个路径信息: ");
        //返回具体的servlet的路径
        System.out.println("getServletPath(小,具体路径): " + req.getServletPath());
        //返回上下文的路径
        System.out.println("getContextPath(大路径): " + req.getContextPath());

        //设置响应头信息
        resp.setHeader("header1", "admin");
        resp.setHeader("header2", "admin");

        //指定服务器响应给浏览器的编码。
        //resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");   //响应类型为HTML格式的
        //1. pageEncoding=”UTF-8”的作用是设置JSP编译成Servlet时使用的编码。
        //2. contentType=”text/html;charset=UTF-8”的作用是指定服务器响应给浏览器的编码。

        //设置响应实体
        //空格算一个字符
        resp.getWriter().print("Hello Servlet,你好");
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hello,你好</h1>\n" +
                "</body>\n" +
                "</html>");

        System.out.println("======================================================================================");

        //获取上下文对象,代表当前应用程序
        System.out.println("上下文对象:  ");
        ServletContext servletContext = req.getServletContext();
        System.out.println("通过上下文对象获取ContextPath:    " + servletContext.getContextPath());
        System.out.println("通过req获取ContextPath:    " + req.getContextPath());
        System.out.println("通过上下文对象获取ContextName:   " + servletContext.getServletContextName());
        System.out.println("通过上下文对象获取RealPath:  " + servletContext.getRealPath("/hello"));

        System.out.println("======================================================================================");

    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁了......");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("带参数的初始化init()=============================");
        //调用父类方法,设置config属性值
        //在第一次有请求访问web应用中的servlet时,tomcat会调用带参数的初始化init()
        super.init(config);
        System.out.println("servletConfig对象:    " + this.getServletConfig());
        System.out.println("通过servletConfig对象获得初始化参数  " + getServletConfig().getInitParameterNames().nextElement() + ":" + getServletConfig().getInitParameter("servletInitParam"));
        System.out.println("通过servletContext对象获得应用的全局初始化参数  " + getServletContext().getInitParameterNames().nextElement() + ":" + getServletContext().getInitParameter("servletContext-param"));
        System.out.println("通过servletContext对象获得应用的全局初始化参数  " + getServletConfig().getInitParameterNames().nextElement() + ":" + getServletContext().getInitParameter("servletContext-param"));

        System.out.println("带参数的初始化init()=============================");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet无参的构造方法(被有参的初始化方法调用)......");
    }

}
