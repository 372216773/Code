package com.wj.aspectj.service;

import org.springframework.stereotype.Service;

//接口的实现类
@Service
public class UserService {

    public void addUser() {
        System.out.println("添加用户操作");
    }

    public void deleteUser() {
        System.out.println("删除用户操作");
    }
}
