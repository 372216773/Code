package com.wj.goods.dao;

import com.wj.goods.entity.Province;
import com.wj.goods.util.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProvinceDao {

    public List<Province> selectAll() throws SQLException {


        List<Province> provinceList = (List<Province>) JdbcUtil.getQueryRunner().query("select * from province", new BeanListHandler(Province.class));
        return provinceList;

    }

}
