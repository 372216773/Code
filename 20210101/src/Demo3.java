public class Demo3 {
    //计算1/1-1/2+1/3-1/4+1/5......+1/99-1/100
    public static void main(String[] args) {
        double sum=0.0;//涉及小数
        for (int i = 1; i <101 ; i++) {
            sum+=1.0/i*Math.pow(-1,i+1);
        }
        System.out.println(sum);
        //out:0.688172179310195
    }
}
