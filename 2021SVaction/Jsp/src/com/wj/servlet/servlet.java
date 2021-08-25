package com.wj.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet")
public class servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        person.setAge(12);
        person.setName("waniscd");

        //对象转换为字符串
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);

        //字符串转为对象
        Person person1 = JSON.parseObject(jsonString, Person.class);
        System.out.println(person1);

        //对象转换为字符串,带日期格式化
        String s = JSON.toJSONStringWithDateFormat(person,JSON.DEFFAULT_DATE_FORMAT);
        System.out.println(s);

        req.setAttribute("user",person);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}

