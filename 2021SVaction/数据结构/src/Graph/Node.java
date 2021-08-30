package Graph;

import java.util.ArrayList;

public class Node {
    //编号,点上的值
    public int value;
    //入度,有多少个点指向这个点的个数
    public int in;
    //出度,这个点指向多少个点的个数
    public int out;
    //这个点指向的所有节点
    public ArrayList<Node> nexts;
    //向外扩展的边(指向其他节点的边)
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
