package com.wj.designPattern.factory.abstractFactory;

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

class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡");
    }
}

interface Drink {
    void drink();
}

class IcePeak implements Drink {

    @Override
    public void drink() {
        System.out.println("喝冰峰");
    }
}

class Cola implements Drink {

    @Override
    public void drink() {
        System.out.println("喝阔乐");
    }
}

interface Factory {
    void getFood();
    void getDrink();
}

class SanQinFactory implements Factory{

    @Override
    public void getFood() {
        new ColdRiceNoodles();
    }

    @Override
    public void getDrink() {
        new IcePeak();
    }
}

class KFCFactory implements Factory{

    @Override
    public void getFood() {
        new Hamburger();
    }

    @Override
    public void getDrink() {
        new Cola();
    }
}


class business {
    public void taste(Factory factory) {

        factory.getDrink();
        factory.getFood();

    }

}

//======================================================================================

class RouJiaMo implements Food{

    @Override
    public void eat() {
        System.out.println("吃肉夹馍");
    }
}

class FenDa implements Drink{

    @Override
    public void drink() {
        System.out.println("喝芬达");
    }
}

class WeiNanFactory implements Factory{

    @Override
    public void getFood() {
        new RouJiaMo();
    }

    @Override
    public void getDrink() {
        new FenDa();
    }
}

public class abstractFactory {
    public static void main(String[] args) {
    }
}
/*
    1.产品
        类
    2.抽象类
        抽象类,接口
   3.产品簇
        多个有内在联系,或者是有逻辑关系的产品,相同厂商的不同类型的商品
   4.产品等级
        不同厂商的相同类型产品

    抽象工厂:
        优点:
            1.仍有简单工厂和工厂的优点
            2.更重要的是,抽象工厂把工厂类的数量减少了很多,无论多少产品等级,工厂就一套

        问:
            1.为什么三秦工厂中,就必须是凉皮配冰峰?不能配可乐呢?

        解释:
            抽象工厂中,可以生产多个产品,这多个产品之间,必须有内在联系,就是产品簇(6mm的螺母和螺丝是一类,8mm的螺母和螺丝是一类,不能乱搭配)
            同一个工厂中的产品都是同一个产品簇,不能把不同产品簇的产品混合到一个抽象工厂的实现类中

        缺点:
            1.当产品等级发生变化(增加或减少产品等级),都要引起以前所有工厂的修改,这就违反了开闭原则(对扩展开放,对修改源代码关闭)

 */