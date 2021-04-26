package com.wj.springboot.conf;

import com.wj.springboot.intercepter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//定义一个配置类
//@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //自定义的拦截器
    @Autowired
    private LoginInterceptor loginInterceptor;

    //注册拦截器,注册一个拦截所有请求的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }
}
