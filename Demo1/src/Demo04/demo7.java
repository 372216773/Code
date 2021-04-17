package Demo04;

import java.util.Scanner;

//7.有 n 个人围成一圈，顺序排号。从第一个人开始报数（从 1 到 3 报数），凡报到 3 的人退出圈
//子，问最后留下的是原来第几号的那位。
public class demo7 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入n值:");
        int n = scanner.nextInt();

        scanner.close();

        boolean[] arrays = new boolean[n];
        int con=0;

        for (int i = 0; i < n; i++) {
            arrays[i] = true;
        }

        for (int i = 0,j=1; con!=n-1 ; i++, j++) {

            if (i==n){
                i=0;
            }

            if (arrays[i]==false){
                j--;
            }else{
                System.out.println("i="+i);
            }

            if (j!=0&&j%3==0){
                arrays[i] = false;
                j=0;
                con++;
                System.out.println("array["+i+"]=被删除");
            }
        }
        for (int i = 0; i < n; i++) {
            if (arrays[i]==true) {
                System.out.println("编号"+i+"是留到最后的人");
            }
        }


    }

}
