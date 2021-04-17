package Demo04;

import java.util.Scanner;

//3.有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
public class Demo3 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("原数组为:7 9 12 34 56 68 90 105 187");
        System.out.println("请输入这个数:");
        int num = scanner.nextInt();

        scanner.close();

        int[] arrays = {7,9,12,34,56,68,90,105,187,0};
        int t;
        int i;
        if(arrays[1]>arrays[0]){//由小到大
            for (i = 0; i < 8&&(arrays[i]>num||arrays[i+1]<num); i++) {
                if (i == 0 && arrays[i] > num) {//头
                    for (int j = 0; j < 10; j++) {
                        t = arrays[j];
                        arrays[j] = num;
                        num = t;
                    }
                }
            }
            if (i<8)//中
                for (int j = i+1; j < 10-i; j++) {
                    t = arrays[j];
                    arrays[j] = num;
                    num = t;
                }else if (i==8&&arrays[i]<num) {//尾
                arrays[i+1] = num;
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(arrays[j]+" ");
        }
    }

}
