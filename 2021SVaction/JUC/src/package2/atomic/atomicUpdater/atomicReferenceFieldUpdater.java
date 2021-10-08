package package2.atomic.atomicUpdater;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/*
字段更新器
 */
public class atomicReferenceFieldUpdater {
    public static void main(String[] args) {
        Student student = new Student();

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,"name");
        System.out.println(updater.compareAndSet(student, null, "张三"));
    }
}
class Student {
    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
