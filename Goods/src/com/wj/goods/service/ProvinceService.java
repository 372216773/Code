package com.wj.goods.service;

import com.wj.goods.dao.ProvinceDao;
import com.wj.goods.entity.Province;

import java.sql.SQLException;
import java.util.List;

public class ProvinceService {

    ProvinceDao provinceDao = new ProvinceDao();
    public List<Province> listAll() throws SQLException {

        List<Province> provinceList = provinceDao.selectAll();

        return provinceList;

    }

}
