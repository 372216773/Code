package com.wj;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class Servlet3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("===========================================================");
        //获取请求方式
        System.out.println("请求方式: " + req.getMethod());

        //统一资源定义符(定位一个资源的位置)
        System.out.println("请求URL: " + req.getRequestURL());

        //统一资源标识符(标识一个资源)
        System.out.println("请求URI: " + req.getRequestURI());

        //获取协议
        System.out.println("请求协议: " + req.getProtocol());

        //
        System.out.println("User-Agent头信息: " + req.getHeader("User-Agent"));
        System.out.println("Accept-Encoding头信息: " + req.getHeader("Accept-Encoding"));

        //获取全部请求头的名称
        Enumeration<String> headerNames = req.getHeaderNames();

        System.out.println("全部请求头: " + headerNames);

        //获取单独的浏览器传递到服务器的参数
        System.out.println("传递的参数: " + req.getParameter("name"));

        //
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry);
        }

        //适用于请求体的编码格式
        req.setCharacterEncoding("utf8");

        resp.getWriter().write("Servlet3");

        System.out.println("===========================================================");
        
    }


}
