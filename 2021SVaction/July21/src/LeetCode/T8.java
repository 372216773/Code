package LeetCode;
/*
对称二叉树
    1
   / \
  2   2
 / \ / \
3  4 4  3
root左树与root右树是否对称
 */
public class T8 {

    public boolean isSymmetric(BTNode root) {
        if(root == null) return false;
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(BTNode BTNode1, BTNode BTNode2) {
        if (BTNode1 == null && BTNode2 != null || BTNode2 == null && BTNode1 != null ) return false;
        if (BTNode1 == null && BTNode2 == null) return true;
        if (BTNode1.val != BTNode2.val) return false;

        return isSameTree(BTNode1.left, BTNode2.right) && isSameTree(BTNode1.right,BTNode2.left);
    }
}
