package com.wj.proxy;

//静态代理
public class App {

    public static void main(String[] args) {

        //创建委托类对象
        Delegate delegate = new Delegate();

        //创建代理类对象
        Proxy proxy = new Proxy(delegate);

        //调用代理类的say()
        String say = proxy.say();

        //创建目标类对象
        Target target = new Target();

        //接收信息
        target.rec(say);

    }

}
