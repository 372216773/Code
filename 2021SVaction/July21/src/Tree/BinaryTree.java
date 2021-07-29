package Tree;

import javax.swing.*;

class BTNode {
    String val;
    BTNode left;
    BTNode right;

    public BTNode(String val) {
        this.val = val;
    }

}

public class BinaryTree {

    //创建树🌳
    public BTNode createTree() {
        BTNode A = new BTNode("a");
        BTNode B = new BTNode("b");
        BTNode C = new BTNode("c");
        BTNode D = new BTNode("d");
        BTNode E = new BTNode("e");
        BTNode F = new BTNode("f");
        BTNode G = new BTNode("g");
        BTNode H = new BTNode("h");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    //每一次递归调用函数,都会开辟栈帧,在没递归完时,就一直存在栈中

    //遍历思路: 递归遍历,每次只要不空, size++;
    //子问题思路: 要求整棵树的节点个数,左数+右树+1

    //前序遍历
    public void preOrderTraversal(BTNode root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public void inOrderTraversal(BTNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    //后序遍历
    public void postOrderTraversal(BTNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    static int size = 0;

    //遍历->求节点个数
    public void getSize(BTNode root) {
        if (root == null) return;
        size++;
        getSize(root.left);
        getSize(root.right);
    }

    //子问题思路->求节点个数
    public int getSize2(BTNode root) {
        if (root == null) return 0;
        size = getSize2(root.left) + getSize2(root.right) + 1;
        return size;
    }

    static int leftSize = 0;

    //遍历思路->求叶子节点个数
    public void getLeftSize1(BTNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leftSize++;
        }
        getLeftSize1(root.left);
        getLeftSize1(root.right);
    }

    //子问题思路->求叶子节点个数
    public int getLeftSize2(BTNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeftSize2(root.left) + getLeftSize2(root.right);
    }

    //子问题思路->求第k层节点个数
    public int getKLevelSize(BTNode root, int k) {
        if (root == null) return 0;
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    //获取二叉树的高度,最大深度
    public int getHeight(BTNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    //
    public int find(BTNode root) {
        return 0;
    }


}
