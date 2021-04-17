package com.wj.goods.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wj.goods.service.LoginService;
import com.wj.goods.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService loginService = new LoginService();
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");
        try {
            String login = loginService.login(nickname, password);
            //返回一个JSON格式的校验码
            JSONObject jsonObject = new JSONObject();

            //登陆成功
            if (login.equals("true")) {
                jsonObject.put("code",666);
                //getSession():从当前request中获取session，如果获取不到session，则会自动创建一个session，并返回新创建的session；
                // 如果获取到，则返回获取到的session;
                //setAttribute():创建属性并赋值
                req.getSession().setAttribute("nickname",nickname);
            }else {//登陆失败
                jsonObject.put("code",0);
            }

            resp.setContentType("application/json");
            //转换为String格式
            resp.getWriter().write(jsonObject.toJSONString());
        } catch (SQLException | NoSuchAlgorithmException throwable) {
            throwable.printStackTrace();
        }
    }
}
