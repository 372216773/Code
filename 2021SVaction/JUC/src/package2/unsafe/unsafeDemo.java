package package2.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class unsafeDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        /*
        获取Unsafe对象
         */

        //获取公有私有属性
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");

        theUnsafe.setAccessible(true);
        //获得成员变量的值,静态属性不需要传递对象
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);

        //1.获取域的偏移地址
        long idOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("name"));

        Student student = new Student();
        //2.执行cas操作

        //id是int类型,name是String类型(引用类型)
        unsafe.compareAndSwapInt(student,idOffset,0,1);
        unsafe.compareAndSwapObject(student,nameOffset,null,"张三");

        //2.验证
        System.out.println(student);
    }
}

//使用Unsafe对象来线程安全的修改Student类的属性(利用的是CAS)
class Student {
    volatile int id;
    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
