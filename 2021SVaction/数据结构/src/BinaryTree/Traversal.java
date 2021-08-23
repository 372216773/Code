package BinaryTree;

import javafx.scene.transform.Scale;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Traversal {

    public static void preOrderRecur(TreeNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.println(head.val + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val + " ");
    }

    //非递归遍历二叉树通过栈实现
    /*
    从栈中弹出一个节点cur
    打印cur
    如果有孩子,先压右孩子,再压左孩子(进栈和出栈的顺序是相反的)
     */
    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            //弹出栈顶元素,压入顺序为右左,则出栈顺序为左右
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /*
    从栈中弹出一个节点cur
    压入第二个栈
    如果有孩子,先压左孩子,再压右孩子
    */
    public static void posOrderUnRecur(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            //弹栈顺序为根,右,左
            TreeNode cur = stack1.pop();
            //存入的顺序为根,右,左,出栈顺序为左,右,根
            stack2.push(cur);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode cur = stack2.pop();
            System.out.print(cur.val + " ");
        }
    }

    /*
    将左孩子全部入栈
    弹出栈顶节点,并打印
    转到右孩子
     */
    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //head!=null,对应当弹出并输出根节点,stack是为空的,但是二叉树并没有遍历完
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                //左中右
                head = stack.pop();
                System.out.println(head + " ");
                head = head.right;
            }
        }
    }

    //头结点进队列,
    // 打印栈顶结点
    //放左节点,放右节点
    public static void w(TreeNode head) {
        if (head == null) return;
        //队列,先进先出
        Queue<TreeNode> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()) {
            TreeNode cur = list.poll();
            System.out.print(cur + " ");
            if (cur.left != null) {
                list.add(cur.left);
            }
            if (cur.right != null) {
                list.add(cur.right);
            }
        }
    }

    //使用hashMap
    public static int treeMaxWidth(TreeNode head) {
        if (head == null) return -1;
        //队列,先进先出
        Queue<TreeNode> list = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(head, 1);
        list.add(head);
        int level = 1;
        int NodeNum = 1;
        int max = -1;
        while (!list.isEmpty()) {
            TreeNode cur = list.poll();

            //这个节点的level
            if (level == map.get(cur)) {
                //当前行数等于map中的行数,属同一行,行中元素个数++
                NodeNum++;
            } else {
                //一行的元素遍历完了,找出个数最多的
                max = Math.max(max, NodeNum);
                //行数++;
                level++;
                NodeNum = 1;
            }

            if (cur.left != null) {
                //当前节点的子节点就是下一层的节点
                map.put(cur.left, level + 1);
                //进栈
                list.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, level + 1);
                //进栈
                list.add(cur.right);
            }
        }
        return max;
    }

    //不用hashMap
    public static int treeMaxWidth1(TreeNode head) {
        if (head == null) return 1;
        //当前行的最后一个结点
        TreeNode curEnd = head;
        //当前节点下一行的最后一个结点
        TreeNode nextEnd = null;
        //最大宽度
        int max = 0;
        //当前行节点个数
        int curLevelNode = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //当前行个数加一
            curLevelNode++;
            if (cur.left != null) {
                stack.push(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                stack.push(cur.right);
                nextEnd = cur.right;
            }

            //接下来遍历的节点都不会是本行的节点
            if (cur == curEnd) {
                //最大值
                max = Math.max(max, curLevelNode);
                //个数重置
                curLevelNode = 0;
                //下一行变当前行
                curEnd=nextEnd;
            }
        }
        return max;
    }

    //如何判断一颗二叉树是否是搜索二叉树？(搜索二叉树:每一颗左子树都比他小,右子树都比他大)
    public static int preValue = Integer.MIN_VALUE;
    //递归
    public static boolean isBSTree(TreeNode head) {
        if (head==null) return true;
        boolean isLeftBst = isBSTree(head.left);
        if (!isLeftBst) return false;
        if (head.val<=preValue) return false;
        //到这的值分别为左值,根值,右值
        preValue = head.val;
        return isBSTree(head.right);
    }
    //非递归
    public static boolean isBSTreeUnRecur(TreeNode head) {
        if (head==null) return false;
        int preValue=Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||head!=null) {
            if (head!=null){
                stack.push(head);
                head=head.left;
            }else {
                head = stack.pop();
                if (head.val<=preValue) return false;
                preValue=head.val;
                head=head.left;
            }
        }
        return true;
    }

    //如何判断一颗二叉树是完全二叉树？(层序遍历--队列)
    // (1)只要有任何一个节点有右孩子,但无左孩子,返回false;
    // (2).在一的条件下,如果遇到第一个左右子节点不全,接下来的节点都会是叶节点
    LinkedList<Integer> linkedList = new LinkedList<>();

    //如何判断一颗二叉树是否是满二叉树？

    //如何判断一颗二叉树是否是平衡二叉树？（二叉树题目套路）

    //给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点

}


