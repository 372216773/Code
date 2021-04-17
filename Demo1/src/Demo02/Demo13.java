package Demo02;

import java.util.Scanner;

//13.输入 2 个整数 time1 和 time2，表示火车的出发时间和到达时间，计算并输出旅途时间。
//有效的时间范围是 0000 到 2359，若出发时间晚于到达时间的则输出：输入有误。
//例：括号内是说明
//输入
//710 1411（出发时间是 7：10，到达时间是 14：11）
//输出
//旅途时间为： 7 小时 1 分钟
public class Demo13 {

    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入出发时间:");
        int time1 = scanner.nextInt();
        System.out.println("请输入到达时间:");
        int time2 = scanner.nextInt();

        scanner.close();

        int mi1 = (time1/100)*60+(time1%100);
        int mi2 = (time2/100)*60+(time2%100);

        if(mi1>mi2){
            System.out.println("输入有误");
        }else{
            System.out.println("旅行时间为:"+((mi2-mi1)/60)+"时"+((mi2-mi1)%60)+"分");
        }
    }
}
