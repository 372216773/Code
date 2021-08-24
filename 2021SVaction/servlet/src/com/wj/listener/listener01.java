package com.wj.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class listener01 implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象创建-------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象销毁-------");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext对象中添加了一个属性" + servletContextAttributeEvent.getName() + ": " + servletContextAttributeEvent.getValue() + "-------");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext对象中移除了一个属性" + servletContextAttributeEvent.getName() + ": " + servletContextAttributeEvent.getValue() + "-------");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext对象中修改了一个属性" + servletContextAttributeEvent.getName() + ": " + servletContextAttributeEvent.getValue() + "-------");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session对象被销毁");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("请求被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("请求创建");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session对象中添加了一个属性" + httpSessionBindingEvent.getName() + ": " + httpSessionBindingEvent.getValue() + "-------");

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session对象中添加了一个属性" + httpSessionBindingEvent.getName() + ": " + httpSessionBindingEvent.getValue() + "-------");

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session对象中添加了一个属性" + httpSessionBindingEvent.getName() + ": " + httpSessionBindingEvent.getValue() + "-------");

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("session对象中添加了一个属性" + servletRequestAttributeEvent.getName() + ": " + servletRequestAttributeEvent.getValue() + "-------");

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("session对象中添加了一个属性" + servletRequestAttributeEvent.getName() + ": " + servletRequestAttributeEvent.getValue() + "-------");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("session对象中添加了一个属性" + servletRequestAttributeEvent.getName() + ": " + servletRequestAttributeEvent.getValue() + "-------");
    }
}
