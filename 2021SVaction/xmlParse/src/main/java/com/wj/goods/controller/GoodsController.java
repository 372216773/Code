package com.wj.goods.controller;

import com.wj.goods.service.GoodsService;

public class GoodsController {
    private GoodsService goodsService;
    public void remove() {
        goodsService.remove();
    }
}
