package Demo03;

//12.一个整数，它加上 100 后是一个完全平方数，再加上 168 又是一个完全平方数，请问该数是
//多少？
public class Demo12 {

    public static void main(String[] args){

        double x;
        for (x = 0;x>-1; x++) {
            if (Math.sqrt(x+100)%1==0&&Math.sqrt(x+168)%1==0){
                System.out.println(x);
                break;
            }
        }


    }

}
