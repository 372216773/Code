package com.wj.goods.controller;

import com.alibaba.fastjson.JSON;
import com.wj.goods.entity.City;
import com.wj.goods.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//根据传来的pid返回对应的city
@WebServlet("/city/*")
public class CityController extends HttpServlet {

    CityService cityService = new CityService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*//返回最后一次出现的指定子字符串在此字符串内的索引
        int indexOf = req.getRequestURI().lastIndexOf("/");
        //返回子字符串以指定索引处的字符开头，并延伸到该字符串的末尾。
        String substring = req.getRequestURI().substring(indexOf);*/
        //获取参数值,传给service处理,将String类型转换为int类型
        int pid = Integer.parseInt(req.getParameter("pid"));
        try {
            List<City> cityList = cityService.listByPid(pid);
            resp.setContentType("application/json;charset=utf8");
            //响应返回JSON格式的数据
            String jsonString = JSON.toJSONString(cityList);
            //传值给jsp页面
            resp.getWriter().write(jsonString);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
