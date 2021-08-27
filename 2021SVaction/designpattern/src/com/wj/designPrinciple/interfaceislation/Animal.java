package com.wj.designPrinciple.interfaceislation;

public interface Animal {
   //并不是所有的动物都会游泳,飞,如果定义一个Dog类让其去实现这个Animal接口,就必须要实现fly()这个方法,显然不合适
    //所以,就要分开总接口,变成一个个的小接口,我们可以有选择地去实现对应的接口
    /* void swim();
    void run();
    void fly();*/
    void eat();
    void sleep();
}

interface runnable{
    void fly();
}
interface swimming{
    void swim();
}