package Secondarypackaging;

public class Test {
    public static void main(String[] args) {
        MyClass myA=new MyClass(1,2);
        ControlClass con=new ControlClass(myA);
        con.Do();
    }
}
