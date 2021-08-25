package com.wj.openclose;

/*
这是基于Car类(不可修改)而扩展出来的扩展类,用来适应变化
 */
public class DiscountCar extends Car {

    @Override
    public double getPrice() {
        return super.getPrice() * 0.8;
    }
}
