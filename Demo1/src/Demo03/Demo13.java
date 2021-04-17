package Demo03;


//13.输出 9*9 口诀。
public class Demo13 {

    public static void main(String[] args){

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i+1; j++) {
                System.out.print(i+"×"+j+"="+(i*j)+" ");
            }
            System.out.println();
        }

    }

}
