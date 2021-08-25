package com.wj.openclose;

public class App {
    public static void main(String[] args) {
        DiscountCar discountCar = new DiscountCar();
        discountCar.setBand("奔驰");
        discountCar.setColor("黑色");
        discountCar.setPrice(666666);

        System.out.println(discountCar);
    }
}
//如果现在这个车要打八折,即通过getPrice应该是原来的0.8倍,但是我们不能修改源代码,这样违背开闭原则,我们可以创建一个字累,重写要变化的内容
/*
开闭原则:
1.对扩展新功能是开放的
2.对修改原有功能是关闭的

如果一个类自始至终都是自己编写的,那就可以随时修改源代码
如果一个类不是自己写的,就不能修改别人的代码,符合开闭原则
 */
