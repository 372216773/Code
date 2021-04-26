package com.wj.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//生成类中所有属性的getter,setter方法、toString方法等。
@Data
//生成全参构造器,会代替掉无参构造器
@AllArgsConstructor

//生成无参构造器
@NoArgsConstructor

//引入slf4j的支持
@Slf4j
public class User {
    private Integer id;
    private String name;
    private Integer age;

    //打印日志
    public void slf4jMes() {
        log.warn("一个警告");
    }

}
