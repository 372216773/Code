package BinaryTree;

import sun.reflect.generics.tree.Tree;

//树的遍历
public class TreeTraversal {
    /*
    对root为根的树进行遍历,遍历的对象是树,不是节点
    虽然形参是根节点,但实际上是以该节点为根的树
     */

    private static int count;
    private static int leaves;

    /**
     *前序遍历
     * {
     *     打印;          //1.打印根节点
     *     root.left;    //2.把root.left子树遍历完
     *     root.right;   //3.把root.right字数遍历完
     * }
     * @param root 根节点
     */
    public static void preTraversal(TreeNode root) {
        //遍历的前提是root不为空
        if (root != null) {
            //1.首先处理根节点
            System.out.print(root.value);
            //2.按照前序的方式,递归处理该节点的左子树
            preTraversal(root.left);
            //3.按照前序的方式,递归处理该节点的右子树
            preTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     * {
     *     root.left;    //1.把root.left子树遍历完
     *     打印;         //2.打印根节点
     *     root.right;  //3.把root.right字数遍历完
     * }
     * @param root 根节点
     */
    public static void inTraversal(TreeNode root) {
        if (root != null) {
            //1.按照中序的方式,递归处理该节点的左子树
            inTraversal(root.left);
            //2.处理根节点
            System.out.print(root.value);
            //3.按照中序的方式.递归处理该节点的右子树
            inTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     * {
     *     root.left;       //1.把root.left的子树遍历完
     *     root.right;      //2.把root.right的子树遍历完
     *     打印;             //3.打印根节点
     * }
     * @param root
     */
    public static void postTraversal(TreeNode root) {
        if (root != null) {
            //1.处理左子树
            postTraversal(root.left);
            //2.处理右子树
            postTraversal(root.right);
            //3.处理根节点
            System.out.print(root.value);
        }
    }

    //利用count计数求节点个数
    public static int countTreeNode(TreeNode root) {
        count = 0;
        preTraversalToCount(root);
        return count;
    }

    //加入计数的前序遍历
    public static void preTraversalToCount(TreeNode root) {
        //遍历的前提是root不为空,遍历每个节点,计数一次
        if (root != null) {
            count++;
            preTraversalToCount(root.left);
            preTraversalToCount(root.right);
        }
    }

    //利用递归求节点个数
    public static int countTreeNodeByRecursion(TreeNode root) {
        //root没有指向任何节点
        if (root == null) {
            //root为null,即没有节点
            return 0;
        } else {
            //root指向某个节点
            int rootNodeSize = 1;
            int leftSubTreeNodeSize = countTreeNodeByRecursion(root.left);
            int rightSubTreeNodeSize = countTreeNodeByRecursion(root.right);
            return rootNodeSize + leftSubTreeNodeSize + rightSubTreeNodeSize;
        }
    }

    //使用遍历求叶子节点个数
    public static int sumTreeLeftNodeSize(TreeNode root) {
        leaves = 0;
        preTraversalToLeftNode(root);
        return leaves;
    }

    //利用计数求叶子节点个数
    public static int sumTreeLeftNodeSizeByCount(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftSubTreeLeftSize = sumTreeLeftNodeSizeByCount(root.left);
            int rightSubTreeLeftSize = sumTreeLeftNodeSizeByCount(root.right);
            return leftSubTreeLeftSize + rightSubTreeLeftSize;
        }
    }

    //加入计数的前序遍历(叶子个数)
    public static void preTraversalToLeftNode(TreeNode root) {
        //遍历的前提是root不为空,遍历每个节点,计数一次
        if (root != null) {

            //每个结点的必经之处
            if (root.right == null && root.left == null) {
                leaves++;
            }
            preTraversalToLeftNode(root.left);
            preTraversalToLeftNode(root.right);
        }
    }

    //求第k层节点个数
    public static int sumKLevelNodeSize(TreeNode root, int k) {
        if (root == null) {
            //代表空树
            return 0;
        } else if (k == 1) {
            //表示第k层的结点
            return 1;
        } else {
            int leftSubTreeK_1 = sumKLevelNodeSize(root.left, k - 1);
            int rightSubTreeK_1 = sumKLevelNodeSize(root.right, k - 1);
            return leftSubTreeK_1 + rightSubTreeK_1;
        }
    }

    //求高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == null && root.left == null) {
            return 1;
        } else {
            int leftSubTreeHeight = getHeight(root.left);
            int rightSubTreeHeight = getHeight(root.right);
            return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        }
    }

    //是否包含v元素
    public static boolean contains(TreeNode root,String v) {
        //根节点为null,叶子节点为遍历完了
        if (root==null) {
            return false;
        }

        //找到值,返回true
        if (root.value.equals(v)) {
            return true;
        }
        boolean left = contains(root.left, v);
        if (left) {
            return true;
        }
        return contains(root.right,v);
    }

    public static TreeNode contains1(TreeNode root,String v) {
        if (root==null) {
            return null;
        }
        if (root.value.equals(v)) {
            return root;
        }
        TreeNode left = contains1(root.left,v);
        //如何根据left判断是否找到v
        //left==null意味着没有找到
        //left!=null意味着找到了
        if (left!=null) {
            return left;
        }
        return contains1(root.right,v);
    }

    public static void main(String[] args) {

        TreeNode a = buildTree.getTree();
        System.out.println(countTreeNodeByRecursion(a));
        System.out.println(sumTreeLeftNodeSize(a));
        System.out.println(sumTreeLeftNodeSizeByCount(a));
        System.out.println(getHeight(a));
    }
}
