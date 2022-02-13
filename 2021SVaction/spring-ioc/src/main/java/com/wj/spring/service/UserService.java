package com.wj.spring.service;

import com.wj.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*@Component*/
@Service
@Import(UserDao.class)
public class UserService {
    @Autowired
            @Qualifier("com.wj.spring.dao.UserDao")
    UserDao userDao;

    public void saveUser() {
        userDao.add();
    }

    /*@Bean
    public UserDao userDao() {
        return new UserDao();
    }*/
}
