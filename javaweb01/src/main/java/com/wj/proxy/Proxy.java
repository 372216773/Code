package com.wj.proxy;

//代理类
public class Proxy implements ProxyInterface{

    Delegate delegate;

    Proxy(Delegate delegate ) {
        this.delegate = delegate;
    }

    @Override
    public String say() {

        //前置增强
        return "isProxied"+delegate.say();

    }
}
