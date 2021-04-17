package com.wj.goods.controller;

import com.wj.goods.annotation.Controller;
import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.RequestMapping;
import com.wj.goods.service.GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping("/goods")
public class GoodsController {

    @Qualifier()
    private GoodsService goodsService;

    @RequestMapping("remove")
    public void remove(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello! " + request.getParameter("name") + " 您正在进行删除操作");
        goodsService.remove(request.getParameter("id"));
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello! " + request.getParameter("name") + " 您正在进行添加操作");
    }

    @RequestMapping("//modify")
    public void modify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Hello! " + request.getParameter("name") + " 您正在进行修改操作");
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Hello! " + request.getParameter("name") + " 您正在查看商品列表");
        List<Map<String, Object>> list = goodsService.list();
        response.setContentType("application/json;charset=utf8");
        response.getWriter().write(String.valueOf(list));
    }

}
