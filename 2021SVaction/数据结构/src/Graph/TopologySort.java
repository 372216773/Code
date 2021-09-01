package Graph;

import java.util.*;

//拓扑排序,spring的循环依赖问题,
// 先找入度为零的点,擦除这个点及其他的所有影响(擦除他的指向out)
public class TopologySort {
    public static List topologySort(Graph graph) {
        //存放点以及对应的剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //这个队列存放所有入度为零的点
        Queue<Node> zeroQueue = new LinkedList<>();
        //values()方法的作用是得到HashMap中的value的集合
        //graph.nodes.values(),获得所有的点找出第一批入度为0的点
        for (Node node : graph.nodes.values()) {
            //存放点以及点的入度
            inMap.put(node,node.in);
            //入度为零,就加入到队列中(队列中存放入度为空的点)
            if (node.in==0) zeroQueue.add(node);
        }

        //存的是所有从队列中出来的入度为零的点
        List<Node> result = new ArrayList<>();

        //所有入度为零的点都已经存到了结果集中,结束循环
        while(!zeroQueue.isEmpty()) {
            Node cur = zeroQueue.poll();
            //加入到结果集中
            result.add(cur);
            //对于一个节点的所有指向的节点,消除他的入度
            for (Node next: cur.nexts) {
                //自动覆盖原来key对应的value,拿到value值减一
                inMap.put(next,inMap.get(next)-1);
                //如果找到有一个节点的入度为零
                if (inMap.get(next)==0) {
                    //就加入到队列中,成为下一个入度为零的点,然后遍历他所指向的所有节点
                    zeroQueue.add(next);
                }
            }
        }
        return result;
    }
}
