package com.wj.goods.service;

import com.wj.goods.entity.City;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CityServiceTest {

    //要用到junit4.jar
    @Test
    public void testListByPid() throws SQLException {

        CityService cityService = new CityService();
        List<City> cities = cityService.listByPid(1);
        System.out.println(cities);

    }

}
