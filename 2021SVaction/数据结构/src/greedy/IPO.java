package greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
输入： 正数数组costs,正数数组profits,正数k,正数m
含义： costs[i]表示i号项目的花费,profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
k表示你只能串行的最多做k个项目,m表示你初始的资金
说明：
你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
输出： 你最后获得的最大钱数。

 */
public class IPO {

    public static class Node {
        public int cost;
        public int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    //按花费从小到大排序
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    //按收益从大到小排序
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int findMaximizedCapital(int k, int M, int[] cost, int[] profit) {
        Node[] nodes = new Node[profit.length];
        for (int i = 0; i < profit.length; i++) {
            nodes[i].profit = profit[i];
            nodes[i].cost = cost[i];
        }
        //按最小花费排序的队列
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        //按最大收益排序的队列
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        Collections.addAll(minCost, nodes);

        //只能做k个项目
        for (int i = 0; i < k; i++) {
            //符合条件的放入收益队列中
            while (!minCost.isEmpty() && minCost.peek().cost <= M) {
                maxProfit.add(minCost.poll());
            }
            //说明成本不足以开启下一个项目,就退出
            if (maxProfit.isEmpty()) return M;
            //取出符合条件,并且受益最大的加入到M中
            M += maxProfit.poll().profit;
        }
        return M;
    }
}
