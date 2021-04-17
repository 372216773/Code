package Secondarypackaging;

public class ControlClass {
    private MyClass my;
    public ControlClass(MyClass t){
        my=t;
    }
    public void Do(){
        my.Print();
    }
}
