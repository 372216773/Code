package Graph;
/*
[5,0,1] 5-->1,权值为5
[3,1,2] 1-->2,权值为3
[7,0,2] 0-->2,权值为7
可以自定义
 */
public class createGraph {

    public static Graph createGraph(Integer[][] matrix) {
        //新建图
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            //获得一个点的信息,只是数值
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            //=============================加图的点集
            //如果图的点集中没有这个点,就把他加到点集中
            if (!graph.nodes.containsKey(from)) {
                //加入点集,此时不指向任何点,没有任何点指向这个点
                graph.nodes.put(from,new Node(from));
            }
            //如果图graph的点集中没有这个点,就把他加到点集中
            if (!graph.nodes.containsKey(to)) {
                //加入点集,此时不指向任何点,没有任何点指向这个点
                graph.nodes.put(to,new Node(to));
            }

            //=============================加图的边集
            //从点集中拿到两个点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            //新建边,有权值,从哪来,到哪去
            Edge newEdge = new Edge(weight, fromNode, toNode);
            //graph的edges
            graph.edges.add(newEdge);

            //=============================为点集中的点赋值
            //fromNode指向结点的个数加1
            fromNode.out++;
            //为fromNode添加指向的节点
            fromNode.nexts.add(toNode);
            //为fromNode添加指向的节点的边
            fromNode.edges.add(newEdge);

            //指向toNode的结点的个数加1
            toNode.in++;
        }
        return graph;
    }
}
