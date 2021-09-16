package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//宽度优先遍历
public class BFS {
    //从node出发,进行宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) return;
        //先进先出
        Queue<Node> queue = new LinkedList<>();
        //可以进行查重
        HashSet<Object> hashSet = new HashSet<>();
        queue.add(node);
        hashSet.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            //遍历cur节点的nexts域
            for (Node next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    //加入到hashSet中(这是之前没有的)
                    hashSet.add(next);
                    //加入到queue中,成为将要便利的点(之前没有遍历过)
                    queue.add(cur);
                }
            }
        }
        String num = "saxsa";
        int a = 12;
        char[] chars = num.toCharArray();
        String s = new String(chars, 0, 3);
        String s1 = new String(String.valueOf(12));

    }
}
