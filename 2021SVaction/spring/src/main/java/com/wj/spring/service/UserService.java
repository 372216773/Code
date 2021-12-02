package com.wj.spring.service;

import com.wj.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private String name;

    /*使用强制访问属性注入*/
    /*按类型注入 如果这个类型有多个实现类,就会报错, 就需要再加上 @Qualifier() 按名称注入(前提是的有名称)*/
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void save() {
        userDao.add();
    }
}
