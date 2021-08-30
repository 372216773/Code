package com.wj.GoodsShow.Controller;

import com.wj.GoodsShow.Service.GoodsService;
import com.wj.GoodsShow.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/goodsList")
public class GoodsController extends HttpServlet {
    GoodsService goodsService = new GoodsService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goodsList = null;
        try {
            goodsList = goodsService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("GoodsList",goodsList);
        resp.sendRedirect("/GoodsList.jsp");
    }
}
