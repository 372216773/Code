package Graph;

//有向边
public class Edge {
    //权重
    public int weight;
    //从哪来
    public Node from;
    //到哪去
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
