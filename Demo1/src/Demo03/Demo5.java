package Demo03;


//5.打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
//例如：153 是一个"水仙花数"，因为 153=1 的三次方＋5 的三次方＋3 的三次方。
//1.程序分析：利用 for 循环控制 100-999 个数，每个数分解出个位，十位，百位。
public class Demo5 {

    public static void main(String[] args){

        int m1 = 0;
        int m2 = 0;
        int m3 = 0;

        for (int i=100; i < 1000; i++) {

            m1 = i/100;
            m2 = i/10-m1*10;
            m3 = i-m1*100-m2*10;

            if(Math.pow(m1,3)+Math.pow(m2,3)+Math.pow(m3,3)==i){
                System.out.println(i);
            }
        }
    }
}
