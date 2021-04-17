package Demo1;

public abstract class Employee extends Role{

    private double salary;
    private static String ID;

    public Employee(){
        System.out.println("抽象类Employee的无参构造器");
    }

    public Employee(double salary,String name,String sex,int age){
        super(name,sex,age);
        this.salary=salary;
        System.out.println("抽象类Employee的有参构造器");
    }

    public static void SetAndGetId(String ID){
        Employee.ID=ID;
        System.out.println(Employee.ID);
    }
    //对于静态的成员是属于类的,所以通过 类名.静态成员名 来访问

    public abstract void play(int age);//覆盖父类play();

    public final void sing(){
        System.out.println("sing a song");
    }
    //此方法不能被重写（可以重载多个final修饰的方法）。
    //此处需要注意的一点是：因为重写的前提是子类可以从父类中继承此方法，
    //如果父类中final修饰的方法同时访问控制权限为private，
    //将会导致子类中不能直接继承到此方法，因此，此时可以在子类中定义相同
    //的方法名和参数，此时不再产生重写与final的矛盾，
    //而是在子类中重新定义了新的方法
}
