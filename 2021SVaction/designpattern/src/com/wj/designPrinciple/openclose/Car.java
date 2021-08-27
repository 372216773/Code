package com.wj.designPrinciple.openclose;
//这是源代码,不能修改,否则会违反开闭原则
public class Car {
    private String band;
    private String color;
    private double price;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        //return price*0.8;不能在这修改,这样会违反开闭原则
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "band='" + band + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
