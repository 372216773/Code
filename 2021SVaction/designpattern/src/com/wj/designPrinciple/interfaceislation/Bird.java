package com.wj.designPrinciple.interfaceislation;

public class Bird implements Animal,swimming{
    @Override
    public void eat() {
        System.out.println("i can eat");
    }

    @Override
    public void sleep() {
        System.out.println("i can sleep");
    }

    @Override
    public void swim() {
        System.out.println("i can swim");
    }
}
