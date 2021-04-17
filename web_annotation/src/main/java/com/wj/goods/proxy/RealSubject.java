package com.wj.goods.proxy;

/*
    真实类(委托类)
 */
public class RealSubject implements Subject{
    @Override
    public String say() {
        return "真实内容";
    }
}
