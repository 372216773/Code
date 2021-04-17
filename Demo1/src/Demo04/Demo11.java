package Demo04;

import java.util.Scanner;

//11.输入数组num[]的大小 size，为数组输入数字，输入要复制的起始位置 index（注意数字范围），
//输入要复制的数字个数 length（注意数字范围），将 index 位置起的 length 个数字复制到数组 num2[]
//中，输出 num2[]中的数字
//原数组为:2 7 6 5 3 1
//size:6 ;index 3 ;length 3;
//新数组为:6 5 3
public class Demo11 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入num[]数组的大小size:");
        int size = scanner.nextInt();
        System.out.println("请为num[]数组输入数组值:");
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = scanner.nextInt();
        }
        System.out.println("请输入要复制的起始位置index:");
        int index = scanner.nextInt();
        index--;
        System.out.println("请输入要复制的数字个数:");
        int length = scanner.nextInt();

        scanner.close();

        int[] num2 = new int[length];
        for (int i = 0; i < length; i++) {
            num2[i] = num[index++];
            System.out.print(num2[i]+" ");
        }

    }

}
