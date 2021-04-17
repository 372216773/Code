package Extends;

public class Student extends Person{

    private String telephone="15769136624";

    Student(){
        System.out.println("Student无参构造器");
    }

    Student(String name,String sex,int age,long Id,String telephone){
        super(name, sex, age, Id);
        this.telephone=telephone;
        System.out.println("调用的是Student有参构造器");
    }

    public void study(){

        System.out.println(name+"is studying");

    }
    public void sleep(){

        System.out.println(name+"is sleeping");

    }

    public void showInformation(){

        System.out.println(this.name);
        System.out.println(this.sex);
        System.out.println(this.age);
        System.out.println(this.Id);
        System.out.println(this.telephone);
    }


}
