package com.wj.goods.service;

import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.Service;
import com.wj.goods.dao.GoodsDao;

import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsService {

    @Qualifier()
    private GoodsDao goodsDao;

    public void remove(String id) {
        goodsDao.delete(id);
    }

    public List<Map<String,Object>> list() {
        return goodsDao.listAll();
    }
}
