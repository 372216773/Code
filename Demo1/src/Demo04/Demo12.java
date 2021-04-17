package Demo04;

import java.util.Scanner;

//12.从某个数组中将 3 的倍数的数字复制出来，构成一个新的数组
//原数组为:9 2 7 6 5 3
//新数组为:9 6 3
public class Demo12 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数组的大小:");
        int length = scanner.nextInt();
        System.out.println("请输入数组值:");
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("原数组为:");
        for (int i:arrays) {
            System.out.print(i+" ");
        }
        System.out.println("\n新数组为:");
        int new_length = 0;
        for (int i = 0; i < length; i++) {
            if (arrays[i]%3==0){
                arrays[new_length++]=arrays[i];
            }
        }
        for (int i = 0; i < new_length; i++) {
            System.out.print(arrays[i]+" ");
        }

    }

}
