package com.wj.goods.controller;

import com.alibaba.fastjson.JSON;
import com.wj.goods.entity.Province;
import com.wj.goods.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/province/list")
public class ProvinceController extends HttpServlet {

    //
    ProvinceService provinceService = new ProvinceService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Province> provinceList = provinceService.listAll();
            //不会识别不出来
            String jsonString = JSON.toJSONString(provinceList);
            //不会乱码
            resp.setContentType("application/json;charset=utf8");
            //传值给原来的jsp页面
            resp.getWriter().write(jsonString);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
