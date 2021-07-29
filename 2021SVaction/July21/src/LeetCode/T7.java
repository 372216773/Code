package LeetCode;

/*

1.判断s和t本身是不是两棵相同的树
2.判断t是不是s的左树
3.判断t是不是s的右树
 */
class BTNode {
    char val;
    BTNode left;
    BTNode right;

    public BTNode(char val) {
        this.val = val;
    }

}

public class T7 {

    public boolean isSubtree(BTNode root, BTNode subRoot) {
        if (root == null || subRoot == null) return false;

        //是否为相同的树
        if (isSameTree(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSameTree(BTNode p, BTNode q) {
        if (p == null && q != null || q == null && p != null) return false;

        if (p == null) return true;
        //根
        if (p.val != q.val) return false;

        //左子树和右子树同时满足,才能说明相等
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
