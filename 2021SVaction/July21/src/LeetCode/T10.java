package LeetCode;

public class T10 {
    public BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
        if (root == null) return null;
        if(root == p || root == q) return root;
        BTNode left = lowestCommonAncestor(root.left, p, q);
        BTNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        if (right == null) return left;
        //没有找到
        return null;
    }
}
