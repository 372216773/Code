package Demo04;

import java.util.Scanner;

//8.从键盘上输入学生人数，使用数组保存所有学生的姓名，电话，语文分数，数学分数，找出语文
//和数学分数最高的学生姓名，找出总分最高的学生姓名，找出两门功课都不及格的学生姓名，输出每
//门课程的平均分
/*
李明 123456 56 48
李华 789 98 87
王京 15769136624 100 100
王雯婧 123456789 59 59

 */

public class Demo8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用本次查询程序");
        System.out.println("请输入要储存的学生总人数:");
        int total = scanner.nextInt();

        String[] name = new String[total];
        long[] telephone = new long[total];
        double[] chinese = new double[total];
        double[] math = new double[total];
        int[] people = new int[total];
        int chinese_max = 0;
        int math_max = 0;
        int max = 0;
        double total_chinese = 0;
        double total_math = 0;

        System.out.println("请依次输入学生姓名,电话,语文成绩,数学成绩:");
        for (int i = 0; i < total; i++) {
            name[i] = scanner.next();
            telephone[i] = scanner.nextLong();
            chinese[i] = scanner.nextDouble();
            math[i] = scanner.nextDouble();
        }

        for (int i = 1; i < total; i++) {
            if (chinese[i] > chinese[chinese_max]) {
                chinese_max = i;
            }
        }

        for (int i = 1; i < total; i++) {
            if (math[i] > math[math_max]) {
                math_max = i;
            }
        }

        for (int i = 1; i < total; i++) {
            if (chinese[i] + math[i] > chinese[max] + math[max]) {
                max = i;
            }
        }

        boolean flag = true;
        while (flag) {
            System.out.println("=============================");
            System.out.println("功能:");
            System.out.println("请输入您要查询的功能序号:");
            System.out.println("[1]:查询语文成绩最高者");
            System.out.println("[2]:查询数学成绩最高者");
            System.out.println("[3]:查询总成绩最高者");
            System.out.println("[4]:查询两门功课都不及格者");
            System.out.println("[5]:查询语文的平均分");
            System.out.println("[6]:查询数学的平均分");
            System.out.println("输入结束退出");
            System.out.println("=============================");

            String num = scanner.next();

            switch (num) {
                case "1":
                    for (int i = 0; i < total; i++) {
                        if (chinese[i] == chinese[chinese_max]) {
                            System.out.println("语文分数最高的者是:" + name[i]+" 成绩为:"+chinese[i]);
                        }
                    }
                    break;
                case "2":
                    for (int i = 0; i < total; i++) {
                        if (math[i] == math[math_max]) {
                            System.out.println("数学分数最高的者是:" + name[i]+" 成绩为:"+math[i]);
                        }
                    }
                    break;
                case "3":
                    for (int i = 0; i < total; i++) {
                        if (chinese[i] + math[i] == chinese[max] + math[max]) {
                            System.out.println("总分分数最高的者是:" + name[i]);
                            System.out.println("总成绩为:"+(chinese[i]+math[i]));
                            System.out.println("语文成绩为:"+chinese[i]);
                            System.out.println("数学成绩为:"+math[i]);
                        }
                    }
                    break;
                case "4":
                    for (int i = 0; i < total; i++) {
                        if (chinese[i] < 60 && math[i] < 60) {
                            System.out.println("姓名:" + name[i]);
                            System.out.println("语文成绩:" + chinese[i]);
                            System.out.println("数学成绩:" + math[i]);
                        }
                    }
                    break;
                case "5":
                    for (int i = 0; i < total; i++) {
                        total_chinese += chinese[i];

                    }
                    System.out.println("语文平均分:" + (total_chinese / total));
                    break;
                case "6":
                    for (int i = 0; i < total; i++) {
                        total_math += math[i];
                    }
                    System.out.println("数学平均分:" + (total_math / total));
                    break;
                case "结束":
                    flag = false;
                    System.out.println("您已结束本次查询使用!");
                    scanner.close();

            }

        }
    }

}
