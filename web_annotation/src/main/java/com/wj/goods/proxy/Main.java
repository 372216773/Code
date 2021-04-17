package com.wj.goods.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //创建一个委托类对象
        RealSubject subject = new RealSubject();

        //使用JDK提供的动态代理,返回代理类的一个实例,这样代理类才会有接口的方法
        Subject proxy = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(), RealSubject.class.getInterfaces(), new InvocationHandler() {
            @Override
            //method:委托类的方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("say")) {
                    return "前置增强 + " + subject.say();
                }
                return null;
            }
        });
        System.out.println(proxy.say());
    }

}
