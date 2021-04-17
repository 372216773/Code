package com.wj.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        //创建委托类的对象
        Delegate delegate = new Delegate();

        //使用JDK提供的动态代理机制
        /*ProxyInterface proxyInstance = (ProxyInterface) Proxy.newProxyInstance(Main.class.getClassLoader(), Delegate.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("say")) {
                    String say = delegate.say();
                    return "isProxies" + say;
                }
                return null;
            }
        });*/

        ProxyInterface proxyInstance = (ProxyInterface) Proxy.newProxyInstance(Main.class.getClassLoader(), Delegate.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("say")) {
                    String say = delegate.say();
                    return "hello" + say;
                }
                return null;
            }
        });
        String say = proxyInstance.say();

        //创建目标类对象

    }

}
