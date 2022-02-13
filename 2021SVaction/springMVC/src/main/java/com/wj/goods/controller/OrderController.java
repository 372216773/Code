package com.wj.goods.controller;

import com.wj.goods.entity.Goods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping("findById")
    public Goods findGoods(@RequestParam("id") String goodsId) {
        Goods good = new Goods(goodsId, "oppo", 2344);
        return good;
    }
}
