package com.wj.designPattern.builder.builder_1;

/*
专门建造一个"ComputerBuilder"类,这个类专门负责封装建造电脑的过程
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

class ComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750HK");
        computer.setGpu("rtx2080i");
        computer.setHd("500g固态+2T机械");
        computer.setMemory("32g");
        return computer;
    }
}

public class builder_1 {
    public static void main(String[] args) {
        //创建一个建造者
        ComputerBuilder computerBuilder = new ComputerBuilder();

        Computer computer = computerBuilder.build();
        Computer computer1 = computerBuilder.build();
        System.out.println(computer + "" + computer1);
    }

}
/*
    这还不是建造者模式
    优点:
        封装了创建电脑的复杂过程
    缺点:
        只会生产一种电脑
 */
