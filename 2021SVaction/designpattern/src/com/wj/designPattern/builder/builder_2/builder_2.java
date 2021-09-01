package com.wj.designPattern.builder.builder_2;

class Computer {
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

class AdvancedComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750HK");
        computer.setGpu("rtx2080i");
        computer.setHd("500g固态+2T机械");
        computer.setMemory("32g");
        return computer;
    }
}
class MidComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        //可能会漏掉
        //computer.setCpu("i7 7700hq");
        computer.setGpu("rtx1060");
        computer.setHd("256g固态+2T机械");
        computer.setMemory("16g");
        return computer;
    }
}
class LowComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 7500u");
        computer.setGpu("rtx940i");
        //可能会漏掉
        //computer.setHd("1T机械");
        computer.setMemory("8g");
        return computer;
    }
}
public class builder_2 {
    public static void main(String[] args) {

    }
}
/*
    优点:
        可以根据客户端的不同需求,使用不同的建造者
    缺点:
        1.代码重复
        2.不稳定,创建对象可能会漏掉一部分,没有一套标准
 */