
public class Main {
    public static void main(String[] args) {

        Person person = new Person();
        person.age = 23;
        person.name = "Jack";
        person.sex = "male";
        System.out.println(person);
    }
}

class Person {
    public int age;
    public String name;
    public static String sex;

    public static void eat() {
        System.out.println( "eat");

    }
}