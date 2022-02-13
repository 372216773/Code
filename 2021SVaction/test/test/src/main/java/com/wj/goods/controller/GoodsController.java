package com.wj.goods.controller;


import com.wj.goods.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @RequestMapping("list")
    public ModelAndView list(@RequestBody Goods goods) {
        System.out.println(goods);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
