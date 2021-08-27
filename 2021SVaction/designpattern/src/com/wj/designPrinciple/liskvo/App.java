package com.wj.designPrinciple.liskvo;

//工具类
class Utils {
    //让他变形,让宽成为长,长成为款=宽,就是一直让宽累加,一直到宽为长的长度+1
    public static void transform(Rectangle r) {
        while (r.getWidth() <= r.getHeight()) {
            r.setWidth(r.getWidth() + 1);
            System.out.println(r.getWidth() + ": " + r.getHeight());
        }
    }
}

//长方形
class Rectangle {
    private double width;
    private double Height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", Height=" + Height +
                '}';
    }
}

class Square extends Rectangle {

    //长宽为一个值
    private double sideLength;


    @Override
    public double getWidth() {
        return this.sideLength;
    }

    @Override
    public void setWidth(double width) {
        this.sideLength=width;
    }

    @Override
    public double getHeight() {
        return this.sideLength;
    }

    @Override
    public void setHeight(double height) {
        this.sideLength=height;
    }
}

public class App {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setHeight(12);
        rectangle.setWidth(12);

        //正方形继承于长方形,但是长方形的业务逻辑已经不符合正方形
        Utils.transform(rectangle);
    }
}
/*
两个类是否能发生继承关系的依据是什么?
主要看有没有"is-a"的关系
在两个类有了"is-a"关系之后,还要考虑子类对象在替换了父类对象之后,业务逻辑是否发生改变!如果发生变化,则不能发生继承关系

正方形和长方形有"is-a"的关系,那么我们能不能让正方形类直接去去继承长方形类呢,肯定不行
因为还要考虑业务场景,看在特定的业务场景下,正方形替换了长方形之后,业务逻辑是否发生变化
 */