package com.wj.proxy2;

import com.wj.proxy.ProxyInterface;

///委托类
public class Delegate implements ProxyInterface {
    @Override
    public String say() {
        return "delegate";
    }
}
