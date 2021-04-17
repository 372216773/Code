package Demo03;

//4.判断 101-200 之间有多少个素数，并输出所有素数，并输出一共有多少个素数
//1.程序分析：判断素数的方法：用一个数分别去除 2 到 sqrt(这个数)，如果能被整除，
//则表明此数不是素数，反之是素数。
public class Demo4 {


    public static void main(String[] args){

        int j=0;
        int con = 0;

        for (int i = 101; i < 201; i++) {
            for (j = 2; j < Math.sqrt(i)&&(i%j!=0); j++) {}
            if(j >= Math.sqrt(i)){
                System.out.print(i+" ");
                con++;
            }
        }
        System.out.println("\n"+con);

    }
}
