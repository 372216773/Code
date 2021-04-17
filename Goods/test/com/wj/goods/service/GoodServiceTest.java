package com.wj.goods.service;

import com.wj.goods.entity.Good;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GoodServiceTest {


    GoodsService goodsService = new GoodsService();

    @Test
    public void testGoods () throws SQLException {

        List<Good> goodList = goodsService.listAll();
        System.out.println(goodList);
    }

    @Test
    public void testAddGoods() throws SQLException {

        int good = goodsService.addGood("小蜜蜂", 23, "huzi.jpg");
        System.out.println(good);

    }

    @Test
    public void testFindGoods() throws SQLException {
        Good good =  goodsService.findGood("1356255877608251393");
        System.out.println(good);
    }

    @Test
    public void testUpdateGood() throws SQLException {

        goodsService.updateGood("7c73ddb6ff954b8389934af9cb4903ec","哈",123,"/upload1caa5bfe012040a1a670853d81bfd86a_huzi.jpg");

        Good good = goodsService.findGood("7c73ddb6ff954b8389934af9cb4903ec");
        System.out.println(good);

    }

    @Test
    public void testSelectAll() throws SQLException {
        List<Good> goodList = goodsService.searchAll("OPP");
        System.out.println(goodList);
    }

}
