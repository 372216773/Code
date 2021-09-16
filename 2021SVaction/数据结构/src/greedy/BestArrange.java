package greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目)，
你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。 返回这个最多的宣讲场次。

策略是:谁先结束,先安排谁
 */
public class BestArrange {

    //项目类
    static class Program {
        //开始时间
        public int start;
        //结束时间
        public int end;
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            //按结束时间排序(谁结束时间早,就排在前边)
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint) {
        //按照一定规则进行排序
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (Program program : programs) {
            //遍历各个任务,如果这个任务开始时间不在设置的时间之前,就可以开始这个任务
            if (timePoint <= program.start) {
                result++;
                //在任务执行完成后才能执行下一个任务,也就是将下一个时间点设置为这次任务完成后的时间之后
                timePoint = program.end;
            }
        }
        return result;
    }
}
