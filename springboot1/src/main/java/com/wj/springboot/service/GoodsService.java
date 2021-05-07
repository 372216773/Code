package com.wj.springboot.service;

import com.wj.springboot.entity.Goods;
import com.wj.springboot.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    public List<Goods> listAll() {
        return goodsMapper.selectAll();
    }
}
