package com.wj;

import java.util.Arrays;

//自定义类型排序,继承Comparable<自定义类型>接口
//并且实现这个接口的抽象方法
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;

    public Student(String name,int age,double score) {
        this.name=name;
        this.age=age;
        this.score=score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override//从小到大排序
    public int compareTo(Student o) {
        if (this.age>o.age) {
            return -1;
        }else if (this.age==o.age) {
            return 0;
        }else {
            return 1;
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        //自定义类型数组,元素为student对象
        Student[] student=new Student[3];
        student[0] =new Student("A",162,4.65);
        student[1] =new Student("B",142,45.2);
        student[2] =new Student("C",172,4.5);
        System.out.println(Arrays.toString(student));
        //调用sort排序,自定义类型的话,不知道以什么来进行排序,
        // 所以就要继承Comparable接口,重写compareTo方法,规定以什么来排序
        Arrays.sort(student);

        System.out.println(Arrays.toString(student));
    }
}
