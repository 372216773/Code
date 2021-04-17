package Extends;

public class Test {
    public static void main(String[] args) {

        Student student=new Student("张三","男",22,10101012,"15769136624");
        student.showInformation();
        student.sleep();
        student.method();

        Teacher teacher=new Teacher();
        teacher.method();
        Teacher.static_method();//直接使用类来调用static方法
        Teacher.static_method(1);//Teacher类中重载的方法
        Teacher.method1();//直接使用类来调用static方法
        Person.static_method();//直接使用类来调用static方法

        Student student1=new Student();
        student1.name="李四";
        student1.age=21;
        student1.Id=1241;
        student1.sex="男";
        student1.showInformation();

    }
}
