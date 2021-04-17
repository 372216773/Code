package com.wj.goods.dao;

import com.wj.goods.entity.City;
import com.wj.goods.util.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDao {

    public List<City> selectByPid(int pid) throws SQLException {


        Integer[] params = new Integer[]{pid};
        //query("sql语句",传递的参数(必须是Object类型),以什么形式传回来,以Bean形式传回来,就需要一个Bean参照)
        List<City> cityList = (List<City>) JdbcUtil.getQueryRunner().query("select * from city where pid=?", params, new BeanListHandler(City.class));
        return cityList;
    }

}
