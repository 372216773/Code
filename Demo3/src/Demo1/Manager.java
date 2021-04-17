package Demo1;

public class Manager extends Employee{

    public Manager(){
        super(12.3,"李四","男",23);
        System.out.println("普通类Manager的无参构造器");
    }

    public static void main(String[] args) {
        //方法体内不允许使用public和private修饰符

        final Manager vehicle=new Manager();
        vehicle.play();//抽象类Role中的play()
        vehicle.play();//抽象类Employee中的play()
        vehicle.SetAge(32);
        vehicle.SetName("wj");
        vehicle.SetSex("男");
        vehicle.GetAge();
        vehicle.GetName();

        vehicle.GetSex();
        vehicle.sing();
        Employee.SetAndGetId("121");//静态方法属于类,通过类来调用
        vehicle.SetAndGetId("141");//也可通过对象调用

    }

    public void play(int age){
        System.out.println("抽象类Employee中的play()");
    }
    public void play(){
        System.out.println("抽象类Role中的play()");
    }
    //两个抽象方法都要实现

}
