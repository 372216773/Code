package com.wj.springboot.mapper;

import com.wj.springboot.entity.Goods;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface GoodsMapper extends Mapper<Goods> {

}
