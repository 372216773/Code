package Demo01;

import java.util.Scanner;
//import java.lang.Math;
//Math类在java.lang包中,默认已经添加
//lang包下的所有类都是默认加载的,不需要import

//3.从键盘上输入圆柱体的底面半径和高，输出圆柱体的体积和表面积
public class Demo3 {
public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    //接受键盘输入数据:底面半径,高

    System.out.println("请输入底面半径:");
    double Bottom_radius = scanner.nextDouble();

    System.out.println("请输入高:");
    double height = scanner.nextDouble();

    scanner.close();

    double surface_area = Math.PI*Math.pow(Bottom_radius,2)*2+2*Bottom_radius*Math.PI*height;
    //S=Πr²*2+2ΠRh;
    double volume = Math.pow(Bottom_radius,2)*Math.PI*height;
    //V=Sh=Πr²h;

    System.out.println("圆柱体的表面积为:"+surface_area);
    System.out.println("圆柱体的体积为:"+volume);
}

}
