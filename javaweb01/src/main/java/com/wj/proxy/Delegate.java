package com.wj.proxy;

///委托类
public class Delegate implements ProxyInterface{
    @Override
    public String say() {
        return "delegate";
    }
}
