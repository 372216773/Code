package Demo04;

import java.util.Scanner;

//1.对 10 个数进行排序
public class Demo1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int[] arrays = new int[10];
        int t;

        System.out.println("请输入待排序的十个数:");
        for (int i = 0; i < 10; i++) {

            arrays[i] = scanner.nextInt();

        }
        System.out.println("排序后由大到小的数组为:");
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                if(arrays[i]<arrays[j]){
                    t = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = t;
                }
            }
            System.out.print(arrays[i]+" ");
        }


    }

}
