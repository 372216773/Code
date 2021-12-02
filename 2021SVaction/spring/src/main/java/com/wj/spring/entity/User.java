package com.wj.spring.entity;

public class User {

    public User() {
        System.out.println("User的构造器");
    }

    /**
     * 静态工厂方法
     * @return User类型的实例
     */
    public static User newInstance() {
        System.out.println("静态工厂方法");
        return new User();
    }

    private String username;
    private String password;
}
