package LeetCode;

/*
一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

求高度

1.当前节点的左树和右树的差是否差 <= 1
2.看左树是否平衡
3.看右树是否平衡



 */
public class T9 {

    //时间复杂度为O(n²):每个节点都要求一次高度
    public boolean isBalanced(BTNode root) {
        if (root == null) return true;

        //左子树与右子树高度进行比较
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        //根节点平衡,以及左子树平衡,右子树平衡
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(BTNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        //+1将根节点加进去
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    //////////////////////////////////////////////////////////////
    //时间复杂度O(n)
    public boolean isBalanced1(BTNode root) {
        if (root == null) return true;

        return height(root) >= 0;

    }

    //递归的同时进行差值比较,一旦不符合条件,就返回-1,就只递归一遍
    public int height(BTNode root) {

        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        //(leftHeight == -1 && rightHeight == -1) || Math.abs(leftHeight - rightHeight) > 1
        //会忽略有一种特殊情况 [1,2,null,3,null,4,null,5] left为-1 right = 0
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
