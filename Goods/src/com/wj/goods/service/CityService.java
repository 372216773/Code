package com.wj.goods.service;

import com.wj.goods.dao.CityDao;
import com.wj.goods.entity.City;

import java.sql.SQLException;
import java.util.List;

public class CityService {

    private final CityDao cityDao = new CityDao();

    public List<City> listByPid(int pid) throws SQLException {

        List<City> cityList = cityDao.selectByPid(pid);
        return cityList;

    }

}
