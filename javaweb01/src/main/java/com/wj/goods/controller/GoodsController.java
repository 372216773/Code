package com.wj.goods.controller;

import com.wj.goods.annotation.Controller;
import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.RequestMapping;
import com.wj.goods.service.GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller()
@RequestMapping("/goods")
public class GoodsController {

    @Qualifier(beanName = "goodsService")
    private GoodsService goodsService;

    @RequestMapping("/remove")
    public void remove(HttpServletRequest request, HttpServletResponse response) {
        //goodsService.remove();
        System.out.println("删除操作");
    }

    @RequestMapping("//add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("添加操作");
        String name = request.getParameter("name");
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("hello! " + name);
        System.out.println("hello! " + name);
    }

    @RequestMapping("/modify")
    public void modify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("修改操作");
    }


}
