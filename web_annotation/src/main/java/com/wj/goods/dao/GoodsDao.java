package com.wj.goods.dao;

import com.wj.goods.annotation.Query;
import com.wj.goods.annotation.Repository;
import com.wj.goods.annotation.Update;

import java.util.List;
import java.util.Map;

@Repository("goodsDao")
public interface GoodsDao {

    @Update("delete from goods where id=?")
    Integer delete(String id);

    @Query("select * from goods")
    List<Map<String,Object>> listAll();
}
