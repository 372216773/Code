public class Demo4 {
    //计算1~100中出现多少个数字9
    public static void main(String[] args) {
        int sum=0;
        for (int i = 1; i < 101; i++) {
            if (i/10==9) {
                sum++;
            }if (i%10==9) {
                sum++;
            }
            //99两种情况都要能进入,用if if
            //if else if只会进一个情况
        }
    }
}
