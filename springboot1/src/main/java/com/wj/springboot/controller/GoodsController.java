package com.wj.springboot.controller;

import com.wj.springboot.entity.Goods;
import com.wj.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("listAll")
    public ModelAndView listAll() {
        List<Goods> goods = goodsService.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goods");
        modelAndView.addObject("goodsList",goods);
        modelAndView.addObject("nickname","admin");
        modelAndView.addObject("myUrl","https://www.bilibili.com/");
        modelAndView.addObject("myImg","/地面小分队悬疑海报.jpg");
        return modelAndView;
    }

}
