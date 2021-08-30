package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //点集,<点的编号,实际的点>
    public HashMap<Integer,Node> nodes;
    //边集,所有的边
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
