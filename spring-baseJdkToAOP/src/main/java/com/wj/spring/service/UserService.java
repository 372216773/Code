package com.wj.spring.service;

import com.wj.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public interface UserService {
    void addUser();
    void deleteUser();

}
