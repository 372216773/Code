package compare;

class Bird{
    String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        /*
        我们需要按照我们的建模方式,给出Java
         */
        //1.this 不是null,检查o是否为null
        if (o == null) {
            return false;
        }

        //2.检查类型,不同的类型,肯定代表不了同一种事物
        if (!(o instanceof Bird)) {
            return false;
        }

        //3.根据设计类的目的,来判断对象是否表示同一个现实事物
        //即名字相同,就代表同一种现实事物
        return this.name.equals(((Bird) o).name);
    }
}
public class equalsTest {
    public static void main(String[] args) {

        /*
        对象是对现实中事物的抽象/建模(建立模型)
        现实事物可能被抽象成多个对象
        多个对象可以表示同一个现实事物
        一个对象不能表示多个事物
         */

        Bird bird = new Bird("bird1");
        Bird bird2 = new Bird("bird1");
        Bird bird3 = new Bird("bird2");
        Bird bird4 = new Bird("bird2");

        System.out.println(bird.equals(bird2));
        /*
        期望是true
        bird和bird2指向的对象代表的是同一种现实的事物
        实际返回false
         */
        System.out.println(bird.equals(bird3));
        /*
        期望是false
        实际返回false
         */

        /*
        因为Java语言本身无法得知,两个对象是否表示同一种现实的事物,需要开发者给出指示-->通过重写equals()
         */
    }
}
