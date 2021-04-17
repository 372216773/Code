package generic;

import java.util.Arrays;
import java.util.Comparator;

/*
泛型(Generic Type)
1.为什么要引入泛型?
    比如:实现一个冒泡排序,void bubbleSort(int[] array)只能排序int型数组
    要排序其他类型就必须重新写
    可以解决问题,但不好
    整个冒泡排序过程中,只有类型在变化,其他不变
    把类型变为"类似变量"的效果
    泛型(通用变量 - 类型做"变量")为此而生
泛型方法语法规则:
T是一个符号,代表一个变化的类型
public static <T> void bubbleSort(T[] array){

}
 */
public class GenericTypeTest {
    //Comparator接口中的抽象方法-->int compare(T o1, T o2);
    //定义了一个接口引用类型(Comparator)的形参变量comparator,可以指向该接口的实现类的对象
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                /*
                T实际是什么类型,Person类型或者其他类型,一般的数据类型的比较用< > ==
                但是比较引用类型的对象就要实现比较接口
                comparator为实现了Comparator接口的类的对象,compare为对象中实现的方法,传递的是"引用"
                 */
                int compare = comparator.compare(array[j], array[j + 1]);
                if (compare > 0) {
                    T t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "GenericTypeTest{}";
    }

    public static void main(String[] args) {
        Person[] person = {
                new Person("小雪", 12, 1.6, 45),
                new Person("小明", 14, 1.7, 55),
                new Person("小星", 18, 1.6, 60),
        };


        System.out.println("未排序之前:");
        System.out.println(Arrays.toString(person));
        //完整写法:传入Person,表示方法的定义时,T就是Person
        System.out.println("按age排序");
        GenericTypeTest.<Person>bubbleSort(person,new PersonByAgeComparator());
        System.out.println(Arrays.toString(person));


        //编译器有能力算出来,这里的T就是Person类型
        System.out.println("按name排序:");
        GenericTypeTest.bubbleSort(person,new PersonByNameComparator());
        System.out.println(Arrays.toString(person));

        //在本类中,直接调用
        System.out.println("按weight排序:");
        bubbleSort(person,new PersonByWeightComparator());
        System.out.println(Arrays.toString(person));

        System.out.println("先按age排序,再按weight排序:");

        //匿名类
        bubbleSort(person, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        if (o1.age != o2.age) {
                            return o1.age - o2.age;
                        } else {
                            return o1.weight - o2.weight;
                        }
                    }
                });
        System.out.println(Arrays.toString(person));
    }
}
