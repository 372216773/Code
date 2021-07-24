public class duoTai {

    //调用这个方法,接口可以实现多态
    public static void walk(IRunning iRunning) {
        iRunning.run();
    }

    public static void main(String[] args) {
        //接口可以向上转型
        IRunning Robot = new Robot("\uD83E\uDD16");
        IRunning Frog = new Frog("\uD83D\uDC38");
        IRunning Cat = new Cat("\uD83D\uDC31");
        walk(Robot);
        walk(Frog);
        walk(Cat);
    }
}

//接口一般都是行为,很少定义变量
interface IFlying {
    void fly();
}

interface ISwimming {
    void swim();
}

interface IRunning {
    void run();
}

/*
因为一个类可能有多个行为,此时既不能使用继承,因为继承是单继承,此时就要实现接口,接口可以多继承
*/

//两栖动物
interface Impervious extends IRunning, ISwimming {
}

//所有动物都会有名字
//但不是所有的动物都会🦅,🏊‍
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

class Fish extends Animal implements ISwimming {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {//实现接口中的方法
        System.out.println("我是" + this.name + ",我能🏊‍");
    }
}

class Bird extends Animal implements IFlying {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {//实现接口中的方法
        System.out.println("我是" + this.name + ",我能🦅");
    }
}

class Robot extends Animal implements IRunning {
    public Robot(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("我是" + this.name + ",我能🏃");
    }
}

class Cat extends Animal implements IRunning {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("我是" + this.name + ",我能🏃");
    }
}

class Frog extends Animal implements Impervious {

    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("我是" + this.name + ",我能🏃‍");
    }

    public void swim() {
        System.out.println("我是" + this.name + ",我能🏊‍");
    }

}
