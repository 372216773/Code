package compare;

import java.util.Comparator;

class Person1 implements Comparable{
    String name;
    int age;
    int height;
    int weight;

    public Person1(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Person1)o).age;
    }
}

class ByHeightComparator implements Comparator<Person1> {

    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.height - o2.height;
    }
}

class ByWeightComparator implements Comparator<Person1> {

    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.weight - o2.weight;
    }
}

public class ComparatorTest {
    public static void main(String[] args) {

        Person1 person = new Person1("小雪", 12, 160, 45);
        Person1 person1 = new Person1("小明", 14, 170, 55);

        ByHeightComparator heightComparator = new ByHeightComparator();
        ByWeightComparator weightComparator = new ByWeightComparator();

        System.out.println(person.compareTo(person1));
        System.out.println(heightComparator.compare(person, person1));
        System.out.println(weightComparator.compare(person, person1));
    }
}

/*
Java中提供了关于对象的比较,有以下方式:
1.equals()
    所有类都具有的能力
    理解:比较两个对象表示的是否是一个实际事物
    规则:需要覆写equals()才能达到
2.大小的比较
    1.自然顺序 Comparable compareTo()
        不是所有类都具有,需要通过实现Comparable接口来表明该类具有这个能力
        理解:比较this和传入的引用指向的对象
    2.外部比较(比较器) Comparator -->构造一个天平
        比较的类不需要具备Comparable的能力
        理解:比较传入的两个引用指向的对象
p1.compareTo(p2) == 0并不能说明两个对象代表的是同一个现实事物
即p1.equals(p2)不一定为true
 */