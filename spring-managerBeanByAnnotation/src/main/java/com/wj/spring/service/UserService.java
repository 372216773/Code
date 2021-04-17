package com.wj.spring.service;

import com.wj.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(UserDao.class)
public class UserService {

    @Autowired//按类型注入,要在BeanFactory中能够找到
            /*@Qualifier("userDao2")//为@Bean注解的值(默认为方法名)*/
            @Qualifier("com.wj.spring.dao.UserDao")
    UserDao userDao;

    public void add() {
        userDao.add();
    }

    /*@Bean
    public UserDao userDao2() {
        return new UserDao();
    }*/

}
