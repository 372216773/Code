package com.wj.factory.Factory;

interface Food {
    void eat();
}

class ColdRiceNoodles implements Food {

    @Override
    public void eat() {
        System.out.println("吃凉皮");
    }
}

class RiceNoodles implements Food {

    @Override
    public void eat() {
        System.out.println("吃米线");
    }
}

interface FoodFactory {
    Food getFood();
}

class ColdRiceNoodlesFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new ColdRiceNoodles();
    }
}

class RiceNoodlesFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new RiceNoodles();
    }
}

class business {
    //需要搭配工厂来使用,所以扩展的时候需要创建工厂
    public static void taste(FoodFactory foodFactory) {
        System.out.println("我在品尝从工厂中获得的食物:  " + foodFactory.getFood());
    }
}

//======================================================================================

class Rice implements Food {

    @Override
    public void eat() {
        System.out.println("吃米饭");
    }
}

class RiceFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Rice();
    }
}

public class Factory {
    public static void main(String[] args) {
        RiceFactory riceFactory = new RiceFactory();
        Food food = riceFactory.getFood();
        food.eat();

        //需要工厂搭配使用的框架
        business.taste(riceFactory);
    }
}
/*
工厂方法:
    优点:
    1.服务器端修改具体产品的类名,客户端不知道
    2.当客户端需要扩展新的产品时,不需要修改原来的代码,只会扩展一个新的工厂,新的产品而已
    3.完全符合开闭原则,不会修改原有功能的基础上,扩展新功能
    缺点:
    1.如果有多个产品等级,类会爆炸式增长,增加一个产品等级,饮品,要产生具体饮品,饮品工厂......

    抬杠:
    1.简单工厂和工厂方法,都有一个优点:就是服务器端的具体产品类名变化之后,客户端是不知道的,
    但是反观现在的代码,客户端依然依赖于具体的工厂类名,此时服务器端修改了具体的工厂类名,那么客户端也要随之一起修改
    又绕回了原点

    解释:
    工厂的名字是被视为接口的,作者有责任有义务保证工厂的名字是稳定的,
    虽然客户端依赖于工厂的具体类名,但是所有工厂的名字都是趋于稳定的(并不是100%),
    至少工厂类的名字要比具体产品类的名字更加稳定

    2.既然产品是我们自己在客户端扩展出来的,我们可以修改产品的类名,那为什么不直接自己实例化调用,为什么还有再扩展一个对象的工厂类?

    解释:
    作者在开发功能的时候,不仅仅只会开发一些抽象产品,具体产品,对应的工厂,还会配套的搭配一些提前做好的框架要配合着工厂使用的,
    所以需要扩展工厂来搭配框架来使用

    3.那为什么不直接使用具体的产品类搭配框架使用呢?为什么还要创建工厂类呢?

    解释:
    又绕回到了原来的问题上,就是工厂类对应具体的产品类更稳定
 */