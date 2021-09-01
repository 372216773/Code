package com.wj.designPattern.builder.builder_3;
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

public class builder_3 {
    public static void main(String[] args) {
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        MidComputerBuilder midComputerBuilder = new MidComputerBuilder();
        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();

        advancedComputerBuilder.setCpu();
        advancedComputerBuilder.setGpu();
        advancedComputerBuilder.setHd();
        advancedComputerBuilder.setMemory();
        Computer computer = advancedComputerBuilder.build();

    }
}
/*
    优点:
        不会漏掉某一步,否则会报错
    缺点:
        变成了客户端指挥建造者来配置电脑,客户端需要知道步骤,违反了迪米特原则
 */