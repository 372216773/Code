package Demo03;

//11.有 1、2、3、4 个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
public class Demo11 {

    public static void main(String[] args){

        int[] arrays = new int[4];
        int sum = 0;
        int con=0;

        for (int i = 0,j=1; i < 4; i++,j++) {
            arrays[i] = j;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j!=k&&j!=i&&i!=k){
                        con++;
                            sum = arrays[i] * 100 + arrays[j] * 10 + arrays[k];
                            System.out.println("三位数为:" + sum);

                    }
                }
            }
        }

        System.out.println("一共有"+con+"个三位数");
    }

}
