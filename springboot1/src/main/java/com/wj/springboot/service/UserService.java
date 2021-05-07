package com.wj.springboot.service;

import com.wj.springboot.entity.User;
import com.wj.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //原因在于DAO接口添加的@Mapper并不是Spring的注解
    //而是ibatis的注解,并没有声明这个DAO接口作为Spring的Bean
    //@Autowired注解是需要对象存在的.但是idea会认为这个值为null,所以爆红
    //1.可以选择给这个注入的类加上@Compent/@Repository......,等一些可以加入到bean工厂中的注解即可
    //2.可以给@Autowired设置值可以为空
    //@Autowired(required = false)
    //private UserMapper userMapper;
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    public Integer updateById(Integer id, String name) {

        return userMapper.updateById(id,name);
    }
}
