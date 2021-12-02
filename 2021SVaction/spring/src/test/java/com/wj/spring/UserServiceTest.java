package com.wj.spring;

import com.wj.spring.config.SpringConfig;
import com.wj.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*加载 spring 的运行环境*/
@RunWith(SpringRunner.class)
/*加载配置文件 还是基于 xml 的配置*/
/*@ContextConfiguration("classpath:applicationContext.xml")*/
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {


/*    private ApplicationContext applicationContext = null;

    @Before
    public void init() {
        applicationContext = new AnnotationConfigApplicationContext("com.wj.spring");
    }
*/
    /*@Autowired(required = true) : required = true 注入失败, 不会向下执行*/
    @Autowired()
    private UserService userService;

    @Test
    public void testSave() {
        userService.save();
    }
}
