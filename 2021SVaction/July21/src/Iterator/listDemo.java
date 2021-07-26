package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

class Student {
    public String name;
    public String grade;
    public double score;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}

public class listDemo {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("a","4",1));
        list.add(new Student("r","7",3));
        list.add(new Student("d","2",0));
        list.add(new Student("c","8",2));
        list.add(new Student("o","1",8));
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
