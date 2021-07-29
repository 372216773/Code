package LeetCode;

/*
相同的树
 */
public class T6 {
    public boolean isSameTree(BTNode p, BTNode q) {

        //结构不对
        if (p == null && q != null || q == null && p != null) return false;

        //树遍历完了,返回true
        if (p == null && q == null) return true;

        //比较根
        if (p.val != q.val) return false;

        //左子树和右子树同时满足,才能说明相等
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
