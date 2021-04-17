package com.wj.goods.dao;

import com.wj.goods.entity.Good;
import com.wj.goods.util.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {

    /**
     * 所有商品
     * @return
     * @throws SQLException
     */
    public List<Good> listAll() throws SQLException {

        List<Good> goodList = (List<Good>) JdbcUtil.getQueryRunner().query("select * from goods", new BeanListHandler(Good.class));

        return goodList;
    }

    /**
     * 单页所有商品
     * @param start 开始位置
     * @param length 单页展示商品数量
     * @return
     */
    public List<Good> listThisPageAll(int start,int length) throws SQLException {

        Object[] params = new Object[]{start,length};
        List<Good> query = (List<Good>) JdbcUtil.getQueryRunner().query("select * from goods limit ?,?", params, new BeanListHandler(Good.class));
        return query;

    }

    /**
     * 商品个数
     * @return
     * @throws SQLException
     */
    public int countGoods() throws SQLException {

        long query = (long) JdbcUtil.getQueryRunner().query("select count(*) from goods", new ScalarHandler());

        return (int) query;
    }

    /**
     * 删除商品
     * @param id
     * @return
     * @throws SQLException
     */
    public int deleteGood(String id) throws SQLException {

        Object[] params = {id};
        int update = JdbcUtil.getQueryRunner().update("delete from goods where id = ?", params);
        //返回受影响的行数,大于0就删除成功
        return update;
    }

    /**
     * 添加商品
     * @param id
     * @param title
     * @param price
     * @param image
     * @return
     */
    public int insert(String id, String title, long price, String image) throws SQLException {

        Object[] params = new Object[]{id,title,price,image};
        int update = JdbcUtil.getQueryRunner().update("insert into goods(id,title,price,image) values(?,?,?,?);", params);

        return update;

    }

    public Good selectGood(String id) throws SQLException {

        Object[] params = new Object[]{id};
        Good query = (Good) JdbcUtil.getQueryRunner().query("select * from goods where id = ?", params, new BeanHandler(Good.class));

        return query;
    }

    public int update(String id,String title, long price, String image) throws SQLException {

        Object[] params = new Object[]{title,price,image,id};

        //更新
        return JdbcUtil.getQueryRunner().update("UPDATE goods SET title=?, price=?, image=? WHERE id=?;",params);
    }

    public List<Good> searchAll(String title) throws SQLException {

        Object[] params = new Object[]{title};

        return (List<Good>) JdbcUtil.getQueryRunner().query("SELECT * FROM goods WHERE MATCH(title) AGAINST(?);", params, new BeanListHandler(Good.class));
    }
}
