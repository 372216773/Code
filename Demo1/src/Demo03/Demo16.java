package Demo03;

//16.有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前 20 项之和。
public class Demo16 {

    public static void main(String[] args){

        int x=1;
        int y=2;
        int t=0;
        double sum=0;

        for (int i = 1; i < 21; i++) {
            System.out.print(y + "/" + x+"+");
            sum += (double) y/x;
            t = x;
            x = y;
            y = t + y;
            if (i%5==0){
                System.out.println();
            }
        }
        System.out.println("\n"+"这个分数序列的前20项之和为:"+sum);

    }

}
