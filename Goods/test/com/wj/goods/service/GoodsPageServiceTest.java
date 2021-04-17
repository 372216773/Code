package com.wj.goods.service;

import com.wj.goods.entity.Good;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GoodsPageServiceTest {

    @Test
    public void TestGoodsPage() throws SQLException {

        GoodsService goodsService = new GoodsService();
        List<Good> goodList = goodsService.listThisPageAll(1, 5);
        System.out.println(goodList);

    }

}
