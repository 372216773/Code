package com.wj.goods.service;

import com.wj.goods.dao.GoodsDao;
import com.wj.goods.entity.Good;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class GoodsService {

    GoodsDao goodsDao = new GoodsDao();

    /**
     * 所有商品
     * @return
     * @throws SQLException
     */
    public List<Good> listAll() throws SQLException {

        List<Good> goodList = goodsDao.listAll();

        return goodList;

    }

    /**
     * 单页商品
     * @param current
     * @param size
     * @return
     * @throws SQLException
     */
    public List<Good> listThisPageAll(int current,int size) throws SQLException {

        //获得开始位置
        int start = (current - 1) * size;
        List<Good> goodList = goodsDao.listThisPageAll(start, size);
        return goodList;

    }

    /**
     * 商品个数
     * @return
     * @throws SQLException
     */
    public int countGoods() throws SQLException {

        int i = goodsDao.countGoods();
        return i;

    }

    public int deleteGood(String id) throws SQLException {

        return goodsDao.deleteGood(id);

    }

    public int addGood(String title, long price, String image) throws SQLException {

        //生成随机id
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        price = price*100;

        int i = goodsDao.insert(id, title, price, image);

        return i;
    }

    public Good findGood(String id) throws SQLException {

        return goodsDao.selectGood(id);

    }

    public int updateGood(String id,String title, long price, String image) throws SQLException {

        return goodsDao.update(id,title,price,image);

    }

    public List<Good> searchAll(String title) throws SQLException {

        return goodsDao.searchAll(title);

    }
}
