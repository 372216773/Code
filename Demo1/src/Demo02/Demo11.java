package Demo02;

import java.util.Scanner;

//11.企业发放的奖金根据利润提成。利润(I)低于或等于 10 万元时，奖金可提 10%；利润高于 10
//        万元，低于 20 万元时，低于 10 万元的部分按 10%提成，高于 10 万元的部分，可可提成 7.5%；20
//        万到 40 万之间时，高于 20 万元的部分，可提成 5%；40 万到 60 万之间时高于 40 万元的部分，可
//        提成 3%；60 万到 100 万之间时，高于 60 万元的部分，可提成 1.5%，高于 100 万元时，超过 100
//        万元的部分按 1%提成，从键盘输入当月利润 I，求应发放奖金总数？
public class Demo11 {

    public static void main(String[] args){

        double money;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入当月利润:");
        int I = scanner.nextInt();

        scanner.close();

        switch (I/10){
            case 0://<10 利润(I)低于或等于 10 万元时，奖金可提 10%
               money = I/10;
                System.out.println("应发奖金总数:"+money);
                break;
            case 1://10~20 利润高于 10万元，低于 20 万元时，低于 10 万元的部分按 10%提成，高于 10 万元的部分，可可提成 7.5%；
                money = 10*0.1+(I*10-10)*0.075;
                System.out.println("应发奖金总数:"+money);
                break;
            case 2:
            case 3://20~40   20万到 40 万之间时，高于 20 万元的部分，可提成 5%
                money = (I*10-20)*0.05;
                System.out.println("应发奖金总数:"+money);
                break;
            case 4:
            case 5://40~60 40 万到 60 万之间时高于 40 万元的部分，可提成 3%
                money = (I*10-40)*0.03;
                System.out.println("应发奖金总数:"+money);
                break;
            case 6:
            case 7:
            case 8:
            case 9://60~100 60 万到 100 万之间时，高于 60 万元的部分，可提成 1.5%
                money = (I*10-60)*0.015;
                System.out.println("应发奖金总数:"+money);
                break;
            default://>100 高于 100 万元时，超过 100万元的部分按 1%提成
                money = (I*10-100)*0.01;
                System.out.println("应发奖金总数:"+money);
                break;
        }


    }
}
