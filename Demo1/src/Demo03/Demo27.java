package Demo03;

import java.util.Scanner;

//27.某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
//每位数字都加上 5,然后用和除以 10 的余数代替该数字，再将第一位和第四位交换，第二位和第三位
//交换。 数组好操作
public class Demo27 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个四位整数:");
        int num = scanner.nextInt();

        scanner.close();

        int[] arrays = new int[4];

        for (int i = 0;num%10!=0; i++) {
            arrays[i] = num%10;
            num = num/10;
        }
        for (int i = 0; i < 4; i++) {
            arrays[i]=(arrays[i]+5)%10;
            System.out.print(arrays[i]);
        }

    }

}
