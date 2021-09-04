package com.wj.goods.service;

import com.wj.goods.dao.GoodsDao;
import com.wj.goods.dao.MemberDao;

public class GoodsService {
    private GoodsDao goodsDao;
    private MemberDao memberDao;
    public void remove() {
        goodsDao.delete();
    }
}
