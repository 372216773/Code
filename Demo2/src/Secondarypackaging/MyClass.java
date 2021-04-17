package Secondarypackaging;

public class MyClass {

    private int x;
    private int y;

    public MyClass(){
        x=0;
        y=0;
    }

    public MyClass(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void Print(){
        System.out.println("MyClass:");
        System.out.println("X:"+x);
        System.out.println("Y:"+y);
    }

}
