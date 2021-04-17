package Demo03;


import java.util.Scanner;

//6.将一个正整数分解质因数。例如：输入 90,打印出 90=2*3*3*5
public class Demo6 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入正整数:");
        int num = scanner.nextInt();

        scanner.close();

        int j = 0;

        for (int i = 2;num!=1; i++) {

            j = num%i;
            if(j==0){
                num = num/i;
                System.out.print(i+" ");
                i--;//确保下一个从当前i值开始
            }

        }

    }
}
