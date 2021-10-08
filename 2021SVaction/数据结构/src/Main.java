import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
8
BBRBRBBR
 */
class Main1 {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = Long.parseLong(scanner.next());
        char[] chars;
        String strings = scanner.next();
        chars = strings.toCharArray();

        System.out.println(count(chars));
    }

    public static long count(char[] chars) {
        long num = 1;
        char color = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != color) {
                num++;
            }
        }
        return num;
    }*/

    /*    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            System.out.println(isTrue(num1, num2));
        }

        public static class Type {
            public int count;
            public boolean b;

            public Type() {
                this.count = 0;
                this.b = true;
            }
        }

        public static Type isTrue(int num1, int num2) {
            Type type = new Type();
            if (num2 < num1) {
                type.count = -1;
                type.b = false;
                return type;
            }

            boolean b = num2 % num1 == 0;

            isTrue(num1, num2 / num1);
        }*/
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(() -> {
            synchronized (A) {
                //代码块
                synchronized (B) {
                    //代码块
                }
            }
        }, "t1");
        new Thread(() -> {
            synchronized (B) {
                //代码块
                synchronized (A) {
                    //代码块
                }
            }
        }, "t2");
    }
}
//给一个等比数列的和,求输出最多项的项数
//修改字符串的代价,将给定字符串修改为自定字符串,大写改成小写,小写改成大写,花费5,字符替换花费5,求总花费
//死锁的产生,解决死锁的方案

/*
由于受到新冠肺炎疫情的影响，2020东京奥运会在推迟一年后终于举行啦！即便是在暑假，“爱学习”的小明同学每周也只能有一天时间看奥运会的比赛。
今天的比赛异常精彩，很多项目都来到了最后的决赛。小明是个有强迫症的小伙子，如果他决定看一个比赛项目，就希望能够从头到尾完整地看完。
已知有2个电视频道在全天转播奥运电视节目，现给出这2个电视频道的节目转播时间表，请问小明最多可以看多少个完整的比赛项目（每个比赛项目对应一个电视节目）？
注：为了对问题进行简化，节目转播时间表只包含比赛项目的开始时间和结束时间（开始时间计入比赛时间，结束时间不计入比赛时间），
且不考虑2个电视频道之间的切换时间，2个电视频道转播的比赛项目也不存在重复。

输入描述
单组输入。 第1行输入两个正整数M和N，分别表示两个电视频道转播的比赛项目（电视节目）的个数，二者之间用空格隔开，
每个电视频道每一天的总节目数不超过30个。 接下来输入M+N行，前M行表示第1个电视频道的节目转播时间表，后N行表示第2个电视频道的节目转播时间表。
每一个电视节目的开始时间和结束时间用24小时制表示，包含小时和分钟，格式为：HH:MM-HH:MM，例如：11:30-13:40。
每两个比赛项目时间之间用空格隔开。

输出描述
输出这一天小明最多可以观看的完整比赛项目的个数。

样例输入
3 4
08:00-09:00
09:30-11:00
13:00-15:00
07:00-08:00
08:00-11:00
12:00-13:30
14:00-17:00
样例输出
5
 */
class Main2 {

    static class TVShow {
        public double start;
        public double end;
    }

    public static class comparator implements Comparator<TVShow> {

        @Override
        public int compare(TVShow o1, TVShow o2) {
            return (int) (o1.end - o2.end);
        }
    }

    public static int method(TVShow[] TVShows) {
        Arrays.sort(TVShows, new comparator());
        double start = TVShows[0].start;
        double end = TVShows[TVShows.length - 1].start;
        int finish = 0;
        for (TVShow show : TVShows) {
            if (show.start >= start) {
                finish++;
                start = show.end;
            }
        }
        return finish;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //个数
        int sum = Integer.parseInt(s.split(" ")[0]) + Integer.parseInt(s.split(" ")[1]);
        //08:00-09:00
        String[] strings = new String[sum];
        TVShow[] TVShows = new TVShow[sum];
        for (int i = 0; i < sum; i++) {
            strings[i] = scanner.nextLine();
            TVShow tvShow = new TVShow();
            String[] split = strings[i].split("-");
            String[] startStr = split[0].split(":");
            tvShow.start = Integer.parseInt(startStr[0]) * 1.0 + Integer.parseInt(startStr[1]) * 0.01;
            String[] endStr = split[1].split(":");
            tvShow.end = Integer.parseInt(endStr[0]) * 1.0 + Integer.parseInt(endStr[1]) * 0.01;
            TVShows[i] = tvShow;
        }

        //System.out.println(Arrays.toString(TVShows));
        System.out.println(method(TVShows));
    }

}

/*
这是一个约瑟夫问题的变形： 有n个人围成一圈进行报数，这n个人的编号分别为1、2、3、......、n。
从编号为1的人开始从1开始报数：编号为1的人报数1，编号为2的人报数2，......，第n个人报完之后第1个人又接着报。
现在给出两个大于1的正整数a和b。报数为a的人首先出局；然后下一个人又从1开始报数，报数为b的人出局；
下一个人再从1开始，报数为a的人出局，......，如此循环。第奇数个出局者为报数为a的人，第偶数个出局者为报数为b的人，
直到只留下一人为止。 现在给出n、a和b，请问最后留下的那个人的编号是多少？
输入描述
单组输入。输入三个正整数n、a和b，n<=1000，a>1，b>1。两两之间用空格隔开。

输出描述
输出最后留下的那个人的编号。

样例输入
6 3 5
样例输出
1
 */
public class Main {

}
