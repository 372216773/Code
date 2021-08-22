package BinaryTree;

import sun.reflect.generics.tree.Tree;

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
            TreeNode cur = stack1.pop();
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

    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        //head!=null,对应当弹出并输出根节点,stack是为空的,但是二叉树并没有遍历完
        while (!stack.isEmpty() || head!=null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode cur = stack.pop();
                System.out.println(cur + " ");
                head = head.right;
            }
        }
    }

    public static void w(TreeNode head) {
        if (head==null) return;
        //队列,先进先出
        Queue<TreeNode> list = new LinkedList<>();
        list.add(head);
        while(!list.isEmpty()) {
            TreeNode cur = list.poll();
            System.out.print(cur+" ");
            if (cur.left!=null) {
                list.add(cur.left);
            }
            if (cur.right!=null) {
                list.add(cur.right);
            }
        }
    }
}


