package com.wj.designPrinciple.dependencyreverse;


//-----作者添加一个接口---------
interface Animal {
    void eat();
}
//---------------------------

class Person {
    void feed(Animal animal) {
        animal.eat();
    }
/*    void feed(Dog dog) {
        dog.eat();
    }
    void feed(Cat cat) {
        cat.eat();
    }*/
}

class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("dog eat");
    }
}

//================================================================================

/*比如，人又养了一只猫，那么上层person这个类当中，就必须在添加喂猫的方法，每当下层变动时，上层也会跟着变动，而我们希望下层变动时，上层不会跟着改变,
 那么作者就应该添加一个接口,使变化的类实现这个接口,person类在调用方法时传递的参数也改为这个接口,其实就是希望发生多态
 原来person类依赖于具体的类,当有新的类想要加进来的时候,就需要重载这个方法,显然不现实,
 所以就添加一个接口,使person类依赖于这个接口,让其他新添加进来的类也都实现这个接口,这时,下层变动时，上层不会跟着改变,就符合依赖倒置原则
*/

class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("cat eat");
    }
}

class Bird implements Animal{
    @Override
    public void eat() {
        System.out.println("bird eat");
    }
}

public class App {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
/*
依赖倒置原则:
上层不能依赖于下层
他们都应该依赖于抽象
 */
