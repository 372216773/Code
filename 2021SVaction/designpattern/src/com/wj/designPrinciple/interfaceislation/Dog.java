package com.wj.designPrinciple.interfaceislation;

public class Dog implements Animal,runnable {
    @Override
    public void eat() {
        System.out.println("i can eat");
    }

    @Override
    public void sleep() {
        System.out.println("i can sleep");
    }

    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
