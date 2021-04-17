package com.wj.spring.service;

import com.wj.spring.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理类
//定义目标对象的工厂类(用于创建目标对象说对应的代理对象)
public class UserServiceFactory {

    public UserService newUserServiceProxy() {
        //创建目标对象
        UserServiceImpl userService = new UserServiceImpl();
        //创建切面对象
        MyAspect myAspect = new MyAspect();
        //创建代理对象
        return (UserService) Proxy.newProxyInstance(UserServiceFactory.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("addUser")) {
                    myAspect.before();
                    userService.addUser();
                }
                if (method.getName().equals("deleteUser")) {
                    myAspect.before();
                    userService.deleteUser();
                    myAspect.after();
                }
                return userService;
            }
        });
    }
}
