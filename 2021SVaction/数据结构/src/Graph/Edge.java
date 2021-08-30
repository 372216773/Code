package Graph;

//有向边
public class Edge {
    //权重(表示距离......)
    public int weight;
    //从哪来(有向边)(A->B和A<-B这个边叫做无向边)
    public Node from;
    //到哪去
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
