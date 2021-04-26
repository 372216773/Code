package com.wj.springboot.mapper;

//Mapper接口必须和映射文件在同一个目录下

import org.apache.ibatis.annotations.Mapper;

//添加了@Mapper注解之后这个接口在编译时会生成相应的实现类,动态代理
@Mapper
public interface UserMapper {
}
