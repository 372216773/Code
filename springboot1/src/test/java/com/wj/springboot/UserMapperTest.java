package com.wj.springboot;

import com.wj.springboot.entity.User;
import com.wj.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//如果于src目录路径不同,就需要在此注解后加上(Application.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
