package com.wj.designPattern.builder.builderFinal;
/*

 */
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

/*
构建一套标准,当装配电脑的时候,必须有这些步骤
 */

interface ComputerBuilder{

    void setCpu();

    void setGpu() ;

    void setMemory() ;

    void setHd() ;

    Computer build();
}

class AdvancedComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7 8750HK");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2080i");
    }

    @Override
    public void setMemory() {
        computer.setMemory("32g");
    }

    @Override
    public void setHd() {
        computer.setHd("500g固态+2T机械");
    }
}

class MidComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7 7700hq");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx1060");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16g");
    }

    @Override
    public void setHd() {
        computer.setHd("256g固态+2T机械");
    }
}

class LowComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public Computer build() {
        return computer;
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7 7500u");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx940i");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8g");
    }

    @Override
    public void setHd() {
        computer.setHd("1T机械");
    }
}

/*
这个类用来指挥装配电脑
 */
class Director{
    public Computer build(ComputerBuilder computerBuilder) {
        computerBuilder.setCpu();
        computerBuilder.setGpu();
        computerBuilder.setHd();
        computerBuilder.setMemory();
        return computerBuilder.build();
    }
}

//-----------------------------------------
public class builder {
    public static void main(String[] args) {
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        MidComputerBuilder midComputerBuilder = new MidComputerBuilder();
        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();

        Director director = new Director();
        Computer computer = director.build(advancedComputerBuilder);
        System.out.println(computer);

    }
}
/*
    优点:
        1.由ComputerBuilder这个接口来稳定过程
        2.创建对象的过程只有一遍,没有重复代码(由指挥者完成)
        3.当需要扩展电脑类时,不需要修改源代码,符合开闭性原则


    建造者与工厂模式的区别:
        1.工厂模式,只需要简单的new出产品即可
        2.建造者模式更注重在new出产品之后为产品属性赋值的过程

 */