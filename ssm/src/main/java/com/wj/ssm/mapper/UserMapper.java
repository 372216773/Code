package com.wj.ssm.mapper;


import com.wj.ssm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /*@Param("id)-->表示形参名称*/
    User findById(@Param("id") Integer id);

}
