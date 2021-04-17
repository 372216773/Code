package Demo03;


//9.一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如 6=1＋2＋3.编程 找出 1000 以
//内的所有完数。
public class Demo9 {

    public static void main(String[] args){

        int sum;
        int i;
        int j;

        for (i = 6; i <= 1000; i++) {
            sum = 0;
            for (j = 1; j < i; j++) {
                if(i%j==0){
                    sum += j;
                }
            }
            if(i==sum){
                System.out.println(i+"是完数");
            }
        }

    }
}
