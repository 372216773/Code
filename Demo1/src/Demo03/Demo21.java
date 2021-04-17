package Demo03;

//21.打印出如下图案（菱形）
//        *              1
//      *****            5
//    **********         10
//  **************       14
//    **********         10
//      *****            5
//        *              1
public class Demo21 {

    public static void main(String[] args){

        int con=1;
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 3; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < con; j++) {
                System.out.print("*");
            }
            con += 4;
            System.out.println();
        }
        con -=4;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("  ");
            }
            con -= 4;
            for (int j = 0; j < con; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
