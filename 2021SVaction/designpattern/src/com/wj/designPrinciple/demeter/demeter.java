package com.wj.designPrinciple.demeter;

class Computer {
    private void save() {
        System.out.println("保存数据");
    }

    private void killProcess() {
        System.out.println("关闭程序");
    }

    private void closeScreen() {
        System.out.println("关闭屏幕");
    }

    private void powerOff() {
        System.out.println("关闭电源");
    }

    public void shutDown() {
        save();
        killProcess();
        closeScreen();
        powerOff();
    }
}

class Person {
    //属于构造代码块
    private Computer computer = new Computer();
    public void shutdownComputer() {
        computer.shutDown();
    }

    /*
    public void shutdownComputer() {
    computer.save();
    computer.killProcess();
    computer.closeScreen();
    computer.powerOff();
    }
    此时,这个Person类对于Computer的细节知道的太多了
    对于Person类而言,只要知道关机键在那就行,不需要自己手动的保存数据,关闭进程,断电这些细节......
    万一使用不当,就会出现错误,
    要避免出错,所以要封装细节,只需要提供一个对外的关机方法
    */
}

//

public class demeter {
    public static void main(String[] args) {
        Person person = new Person();
        person.shutdownComputer();
    }

}
/*
迪米特法则:也叫做最少知道原则(封装)
 */
