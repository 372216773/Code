public class digui {
    //递归

    public static void main(String[] args) {

        TowerOfHanoi(1,'A','B','C');
        System.out.println();
        TowerOfHanoi(2,'A','B','C');
        System.out.println();
        TowerOfHanoi(3,'A','B','C');
        System.out.println();
        TowerOfHanoi(4,'A','B','C');
        System.out.println();
        TowerOfHanoi(5,'A','B','C');
        System.out.println();

        System.out.println(jumpFrog(1));
        System.out.println(jumpFrog(2));
        System.out.println(jumpFrog(3));
        System.out.println(jumpFrog(4));
        System.out.println(jumpFrog(5));
        System.out.println(jumpFrog(6));
        System.out.println(jumpFrog(7));
        System.out.println(jumpFrog(8));
        System.out.println(jumpFrogPlus(1));
        System.out.println(jumpFrogPlus(2));
        System.out.println(jumpFrogPlus(3));
        System.out.println(jumpFrogPlus(4));
        System.out.println(jumpFrogPlus(5));
        System.out.println(jumpFrogPlus(6));
        System.out.println(jumpFrogPlus(7));

    }

    public static void func(int n) {
        if(n/10!=0){
            func(n/10);
        }
        System.out.println(n%10+" ");

    }

    public static int func1(int n) {
        if (n==1) {
            return 1;//终止条件
        }
        return n+func1(n-1);//调用自身
    }

    public static int func2(int n) {
        if (n/10!=0) {
            return n%10+func2(n/10);
        } else {
            return n;
        }
    }

    public static int fibonacci(int n) {//多路递归
        if(n==1||n==2) {
            return 1;//终止条件
        }else {
            return fibonacci(n-1)+fibonacci(n-2);//通式
        }
    }


    public static void move (char pos1,char pos2) {
        System.out.print(pos1+"->"+pos2+" ");
    }
    /** @Title TowerOfHanoi 汉诺塔
     * @Description 特点:将n-1个盘子挪到第二个柱子上,将第一个柱子上的盘子挪到第三个柱子上,
     * 最后将第二个柱子上的盘子挪到第三个柱子上
     * @Param [n 盘子个数, pos1, pos2, pos3]
     * @return void 
     * @Author WJ        
     * @Date 13:52 2021/1/2
    */
    public static void TowerOfHanoi (int n,char pos1,char pos2,char pos3) {
        if (n==1) {
            move(pos1,pos3);
        }else {
            TowerOfHanoi(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            TowerOfHanoi(n-1,pos2,pos1,pos3);
        }
    }
    /** @Title 青蛙跳台阶
     * @Description 变相的fibonacci数列
     * 1,2,3,5,8,13
     * 1,2,3,4,5,6
     * 分为两种:1.先跳一阶+jumpFlog(n-1)
     *        2.先跳两阶+jumpFlog(n-2)
     * @Param [n]
     * @return int
     * @Author WJ
     * @Date 17:17 2021/1/2
    */
    public static int jumpFrog (int n) {
        if (n<1) {
            return -1;
        }if (n==1) {
            return 1;
        }if (n==2) {
            return 2;
        }
        return jumpFrog(n-1)+jumpFrog(n-2);
    }
    /** @Title
     * @Description
     * 1 2 4 8 16 32 64
     * 1 2 3 4 5  6  7 台阶数
     * @Param [n]
     * @return int
     * @Author WJ
     * @Date 17:47 2021/1/2
    */
    public static int jumpFrogPlus (int n) {
        if (n==1) {
            return 1;
        }
        return 2*jumpFrogPlus(n-1);
    }
}
