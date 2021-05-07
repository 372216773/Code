package com.wj.springboot.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    /*
    将返回的对象存放到bean中
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    /*application.properties是springboot默认读取属性的文件
    从这个文件中读取jdbc开头的属性,并通过druidDataSource对象的set方法进行属性注入
    所以对于属性名必须与默认相同,不同的话找不到对应的set方法进行注入
    */
    public DataSource dataSource() {
        return new DruidDataSource();

    }

}
