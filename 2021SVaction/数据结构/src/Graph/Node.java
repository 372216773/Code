package Graph;

import java.util.ArrayList;

public class Node {
    //编号
    public int value;
    //入度
    public int in;
    //出度
    public int out;
    //指向的节点
    public ArrayList<Node> nexts;
    //拥有的边
    public ArrayList<Edge> edges;
}
