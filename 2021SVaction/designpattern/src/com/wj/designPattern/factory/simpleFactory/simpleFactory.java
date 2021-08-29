package com.wj.designPattern.factory.simpleFactory;

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

class FoodFactory {
    public static Food getFood(String foodName) {
        Food food =null;
        switch (foodName) {
            case "ColdRiceNoodles":
                //生产凉皮
                food = new ColdRiceNoodles();
            break;
            case "RiceNoodles":
                //生产米线
                food = new RiceNoodles();
                break;
            default:
                System.out.println("我们没这种商品");
        }
        //拿给用户
        return food;
    }

}

//========================================================

//客户端想要扩展,工厂中没有,因为没有源代码,所以也不能加到工厂中
class rice implements Food{

    @Override
    public void eat() {
        System.out.println("吃米饭");
    }
}

public class simpleFactory {
    public static void main(String[] args) {
        //从工厂中拿东西,不直接拿东西
        Food food = FoodFactory.getFood("ColdRiceNoodles");
        food.eat();
    }
}
/*
简单工厂模式
    优点:
    1.把具体产品的类型,从客户端中解耦出来(不需要知道具体类名)
    2.服务器端,如果修改了具体产品的类名,客户端是不知道
    这便符合了"面向接口编程",也符合迪米特法则(最少知道原则)
    缺点:需要扩展时就显现出来的缺点
    1.客户端不得不死记那些常量与具体产品的映射关系
    2.如果具体产品特别多,那么简单工厂就会变得非常臃肿
    3.客户端想要扩展具体产品时,势必要修改简单工厂的代码(switch语句),这就违反了开闭原则(对扩展开放,对修改原功能关闭)
 */