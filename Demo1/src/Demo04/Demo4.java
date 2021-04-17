package Demo04;

import java.util.Scanner;

//4.将一个数组逆序输出
public class Demo4 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要逆置的数组的大小:");
        int num = scanner.nextInt();
        System.out.println("请输入需要逆置数组");

        int[] arrays = new int[num];
        int t;

        for (int i = 0;i<num ; i++) {
            arrays[i] = scanner.nextInt();
        }

        scanner.close();

        for (int i = 0; i < num/2; i++) {
            t = arrays[i];
            arrays[i] = arrays[num-1-i];
            arrays[num-1-i] = t;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(arrays[i]+" ");
        }
    }

}
