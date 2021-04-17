package com.wj.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
    1.接收客户端的请求
    2.分发请求
 */

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        Map handlerMapping = (Map) getServletContext().getAttribute("handlerMapping");
        Map beanFactory = (Map) getServletContext().getAttribute("applicationContext");
        List allClassNameList = (List) getServletContext().getAttribute("allClassNameList");

        //URI:/goods/add
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        Method method = (Method) handlerMapping.get(requestURI);
        try {
            //调用Method类代表的方法
            method.invoke(beanFactory.get(split[1] + "Controller"), req, resp);
        }  catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}