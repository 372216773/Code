package generic;

public class generic_class<T> {
    public String name;
    public int age;

    public T especial;

    public generic_class(String name, int age, T especial) {
        this.name = name;
        this.age = age;
        this.especial = especial;
    }

    public static void main(String[] args) {
        //T为String类型,所以especial也为String类型的数据
        generic_class<String> p1 = new generic_class<>("小花",18,"字符串");

        //T为Person类型,所以especial也为Person类型的值,即Person类型的对象
        generic_class<Person> p2 = new generic_class<>("小花",18,new Person("小明",12,23,34));
    }
}
