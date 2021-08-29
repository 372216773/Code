package com.wj.designPattern.proxy.Test;

interface ICalc {
    int add(int a, int b);

    int sub(int a, int b);

    int mul(int a, int b);

    int div(int a, int b);
}

class CalcImpl implements ICalc {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}

//==============================================

class MYyCalc extends CalcImpl {
    @Override
    public int add(int a, int b) {
        System.out.println("日志--记录add方法开始时刻: a=" + a + ",b=" + b);
        int result = super.add(a, b);
        System.out.println("日志--记录add方法结束时刻: result=" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("日志--记录sub方法开始时刻: a=" + a + ",b=" + b);
        int result = super.sub(a, b);
        System.out.println("日志--记录sub方法结束时刻: result=" + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("日志--记录mul方法开始时刻: a=" + a + ",b=" + b);
        int result = super.mul(a, b);
        System.out.println("日志--记录mul方法结束时刻: result=" + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("日志--记录div方法开始时刻: a=" + a + ",b=" + b);
        int result = super.div(a, b);
        System.out.println("日志--记录div方法结束时刻: result=" + result);
        return result;
    }
}

public class Test {
    public static void main(String[] args) {
        MYyCalc mYyCalc = new MYyCalc();
        mYyCalc.add(1, 2);
        mYyCalc.div(1, 2);
        mYyCalc.sub(1, 2);
        mYyCalc.mul(1, 2);
    }
}
/*
如果想要为每个方法都加入日志功能,在不违反开闭原则的情况下,继承父类,在子类中添加日志输出的语句,这样是简单的完成了功能,
但是缺点:
    如果需要对日志内容频繁的修改,工程量过大,所以就要学习jdk的api:动态代理

 */