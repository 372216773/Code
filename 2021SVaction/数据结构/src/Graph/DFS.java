package Graph;

import java.util.HashSet;
import java.util.Stack;

//深度优先遍历/广度优先遍历
public class DFS {

    public static void dfs(Node node) {
        if (node == null) return;
        //先进后出
        Stack<Node> stack = new Stack<>();
        //可以进行查重
        HashSet<Object> hashSet = new HashSet<>();
        stack.push(node);
        hashSet.add(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                //逮住一条路走,只要发现之前没走过,就走这条路,不管其他路,一条路走到黑
                if (!hashSet.contains(next)) {
                    //又回到到栈中
                    stack.push(cur);
                    //加入要遍历的节点
                    stack.push(next);
                    //加入到hashSet中,作为查重的元素
                    hashSet.add(next);
                    System.out.print(next.value + " ");
                    //不管其他的节点,只要找到一个,就走这个节点
                    break;
                }
            }
        }
    }
}
