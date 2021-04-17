package Demo1;

public abstract class Role {

    private String name;
    private int age;
    private String sex;
    //构造方法
    public Role(){
        System.out.println("抽象类Role的无参构造器");
    }

    public Role(String name,String sex,int age){
        this.name=name;
        this.age=age;
        this.sex=sex;
        System.out.println("抽象类Role的有参构造器");
    }

    public void GetName(){
        System.out.println(this.name);
    }
    public void GetAge(){
        System.out.println(this.age);
    }
    public void GetSex(){
        System.out.println(this.sex);
    }
    //
    public void SetName(String name){
        this.name=name;
    }
    public void SetSex(String sex){
        this.sex=sex;
    }
    public void SetAge(int age){
        this.age=age;
    }

    public abstract void play();

}
