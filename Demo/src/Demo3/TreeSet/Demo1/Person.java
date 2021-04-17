package Demo3.TreeSet.Demo1;

import java.util.TreeSet;

public class Person extends TreeSet implements Comparable{

    private int age;
    private String name;
    private String school;

    @Override
    public int compareTo(Object o) {
        Person p=(Person)o;
        return this.age-p.age;
    }

   
}
