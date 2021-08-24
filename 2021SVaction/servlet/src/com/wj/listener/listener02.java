package com.wj.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class listener02 implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听到servletContext初始化init......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听到servletContext销毁......");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("");
    }
}
