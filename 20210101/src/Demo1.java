public class Demo1 {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("nac");
        student.setAge(12);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student);
    }
}
class Student {
    private String name;
    private int age;

    public void show() {
        System.out.println("name:"+name+"age:"+age);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
