package generic;

/*
java中的类在实现时,需要声明自己具有比较大小的能力,通过实现Comparable接口
具备xxx的能力
 */
class Person implements Comparable<Person> {
    String name;
    int age;
    double height;
    int weight;

    public Person(String name, int age, double height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    /*
        通过重写该方法,知道Java,进行对象比较大小的
        大小关系如何决定,留给开发者自己决定
        目前的实现,是按照年龄的大小进行比较
         */
    @Override
    public int compareTo(Person o) {

        return this.age - o.age;

        /*if (this.age < o.age) {
            //this指向的对象小于o所指向的对象
            return -1;//任何负数都可以
        }else if (this.age == o.age) {
            //this指向的对象等于o指向的对象
            return 0;
        }else {
            //this指向的对象大于o指向的对象
            return 1;//任何正整数都可以
        }*/
    }



}
