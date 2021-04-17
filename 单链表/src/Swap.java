import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入两个想要进行交换的值");
        MyValue myValue1=new MyValue();
        myValue1.val=scanner.nextInt();;
        MyValue myValue2=new MyValue();
        myValue2.val=scanner.nextInt();
        System.out.println(myValue1.val+" "+myValue2.val);
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+myValue2.val);
    }

    /*
    写一个方法来交换两个数的值,使用类与对象
     */
    public static void swap(MyValue a,MyValue b) {
        int tmp=a.val;
        a.val=b.val;
        b.val=tmp;
    }
    /* @Title
     * @Description 当成员变量被封装时,用get,set方法操作
     * @Param [a, b]
     * @return void
     * @Author WJ
     * @Date 15:57 2021/1/3
    */
    public static void swap1(MyValue a,MyValue b) {
        int tmp=a.getVal();
        a.setVal(b.getVal());
        b.setVal(tmp);
    }
}
class MyValue {
    public int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
