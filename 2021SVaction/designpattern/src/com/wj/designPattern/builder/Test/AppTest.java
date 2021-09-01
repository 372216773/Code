package com.wj.designPattern.builder.Test;
/*
需求:定义一个电脑类,并且实例化出电脑的对象,以及给该对象的属性赋值
 */

class computer{
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;

    @Override
    public String toString() {
        return "computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
}

public class AppTest {
    public static void main(String[] args) {
        computer computer = new computer();
        computer.setCpu("i7 7500u");
        computer.setGpu("gt940mx");
        computer.setMemory("16g");
        computer.setHd("1T机械");

        System.out.println(computer);
    }
}
/*
    缺点:1.客户端程序员必须在实例化好产品的对象之后,为该对象的每一个属性赋值,这样对于客户端程序员你来说,太麻烦了
        2.违反了迪米特原则(最少知道原则)
        相当于买电脑,买一堆零件,自己还要组装


    建造者模式与工厂模式
        1.工厂模式,都是直接实例化出一个类的对象即可(new出来直接用)
        2.建造者模式,是在实例化出列的对象之后,还要给对象的属性赋值(new出来还要进行赋值)
 */