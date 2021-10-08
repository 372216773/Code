package BinaryTree;

import javafx.scene.transform.Scale;
import jdk.nashorn.internal.ir.TernaryNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Traversal {


    //3,5,1,6,2,0,8,null,null,7,4
    public TreeNode createTree() {
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(1);
        TreeNode D = new TreeNode(6);
        TreeNode E = new TreeNode(2);
        TreeNode F = new TreeNode(0);
        TreeNode G = new TreeNode(8);
        TreeNode H = new TreeNode(7);
        TreeNode I = new TreeNode(4);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.left = H;
        E.right = I;
        return A;
    }

    //[1,null,2,null,3,null,4,null,5]
    public TreeNode createTree1() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);

        A.right = B;
        B.right = C;
        C.right = D;
        D.right = E;

        return A;
    }

    public static void preOrderRecur(TreeNode head) {
        if (head == null) return;

        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //所有树都满足中左右
    public static void preOrderRecur1(TreeNode root) {
        if (root == null) return;

        //先打印
        System.out.print(root.val + " ");
        //遍历左树
        preOrderRecur1(root.left);
        //遍历右树
        preOrderRecur1(root.right);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) return;

        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    //所有树都满足左中右
    public static void inOrderRecur1(TreeNode root) {
        if (root == null) return;

        inOrderRecur1(root.left);
        System.out.print(root.val + " ");
        inOrderRecur1(root.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val + " ");
    }

    //所有树都满足左右中
    public static void posOrderRecur1(TreeNode root) {
        if (root == null) return;

        posOrderRecur1(root.left);
        posOrderRecur1(root.right);
        System.out.print(root.val + " ");
    }


    //非递归遍历二叉树通过栈实现----------------------------------------

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
    public static void preOrderUnRecur1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //左右,出栈右左,.......
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
            //弹栈顺序为根,右,左
            TreeNode cur = stack1.pop();
            //存入的顺序为根,右,左,出栈顺序为左,右,根
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode cur = stack2.pop();
            System.out.print(cur.val + " ");
        }
    }
    public static void posOrderUnRecur1(TreeNode root) {
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            stack1.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
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

    //-----------------------------------------------------------

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

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        //<节点,下标索引>
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        hashMap.put(root, 1);
        //遍历这棵树
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int size = 0;
        int max = 0;
        int end = 1;
        while (!stack.isEmpty()) {
            size = stack.size();
            int start = hashMap.get(stack.peek());
            max = Math.max((end - start + 1), max);
            while (size-- > 0) {
                TreeNode cur = stack.poll();
                if (cur.left != null) {
                    hashMap.put(cur.left, hashMap.get(cur) * 2);
                    stack.add(cur.left);
                    end = hashMap.get(cur.left);
                }
                if (cur.right != null) {
                    hashMap.put(cur.right, hashMap.get(cur) * 2 + 1);
                    stack.add(cur.right);
                    end = hashMap.get(cur.right);
                }
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
                curEnd = nextEnd;
            }
        }
        max = Math.max(max, curLevelNode);
        return max;
    }

    //搜索二叉树
    //如何判断一颗二叉树是否是搜索二叉树？(搜索二叉树:每一颗左子树都比他小,右子树都比他大)
    public static int preValue = Integer.MIN_VALUE;

    //递归
    public static boolean isBSTree(TreeNode head) {
        if (head == null) return true;
        boolean isLeftBst = isBSTree(head.left);
        if (!isLeftBst) return false;
        if (head.val <= preValue) return false;
        //到这的值分别为左值,根值,右值
        preValue = head.val;
        return isBSTree(head.right);
    }

    //递归1,树形DP(动态规划),递归套路,要求就要相同,信息要全集(所有需要信息的集合)
    //左树为搜索树,右树为搜索树,左树的max<x,右树的min>x
    public static boolean isBSTree1(TreeNode head) {
        return process_isBSTree(head).isBSTree;
    }

    public static class ReturnType_isBSTree {
        public boolean isBSTree;
        public int max;
        public int min;

        public ReturnType_isBSTree(boolean isBSTree, int max, int min) {
            this.isBSTree = isBSTree;
            this.max = max;
            this.min = min;
        }
    }

    private static ReturnType_isBSTree process_isBSTree(TreeNode head) {
        //max和min值都不好设置,就设置为null,下边调用的时候要做判断
        if (head == null) return null;
        //====================================================================
        //左树的所有信息,会产生null;
        ReturnType_isBSTree leftTree = process_isBSTree(head.left);
        //右树的所有信息
        ReturnType_isBSTree rightTree = process_isBSTree(head.right);
        //====================================================================
        //自己的所有信息
        int max = head.val;
        int min = head.val;
        //排除掉空的情况
        if (leftTree != null) {
            max = Math.max(leftTree.max, max);
            min = Math.min(leftTree.min, min);
        }
        if (rightTree != null) {
            max = Math.max(rightTree.max, max);
            min = Math.max(rightTree.min, min);
        }
        Boolean isBSTree = true;
        //不满足搜索二叉树的条件,isBSTree设置为false;子树为null满足要求
        if (leftTree != null && (!leftTree.isBSTree || leftTree.max >= head.val)) isBSTree = false;
        if (rightTree != null && (!rightTree.isBSTree || rightTree.min <= head.val)) isBSTree = false;
        //====================================================================
        return new ReturnType_isBSTree(isBSTree, max, min);
    }

    public static boolean isBSTreeUnRecur(TreeNode head) {
        if (head == null) return false;
        //做为比较值存在
        int preValue = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.val <= preValue) return false;
                preValue = head.val;
                head = head.left;
            }
        }
        return true;
    }

    //如何判断一颗二叉树是完全二叉树？(层序遍历--队列)
    /*(一)
    (1).只要有任何一个节点有右孩子,但无左孩子,返回false;
    (2).在一的条件下,如果遇到第一个左右子节点不全,接下来的节点都会是叶节点
    */
    public static boolean isCompleteTree(TreeNode head) {
        boolean flag = false;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()) {
            head = list.poll();
            //有节点标记为flag,则后边的节点都为叶节点
            if (flag && (head.left != null || head.right != null) || (head.left == null && head.right != null))
                return false;
            //有节点标记为flag,则后边的节点都为叶节点
            if (head.left != null) {
                list.add(head.left);
            }
            if (head.right != null) {
                list.add(head.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    public static boolean isCompleteTree1(TreeNode head) {
        if (head == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(head);
        TreeNode cur = head;
        while (cur != null) {
            cur = list.poll();
            if (cur != null) {
                list.add(cur.left);
                list.add(cur.right);
            }
        }
        //此实战中应该全是null
        for (TreeNode node : list) {
            if (node != null) return false;
        }
        return true;
    }

    //如何判断一颗二叉树是否是满二叉树？
    //1.l:最大深度;n:节点个数 满足(n=2^l-1),就是满二叉树,所以需要两个值l和n
    public static boolean isFullTree(TreeNode head) {
        if (head == null) return true;
        ReturnType_isFullTree data = process_isFullTree(head);
        return 1 << data.height == data.nodeNum;
    }

    public static class ReturnType_isFullTree {
        public int height;
        public int nodeNum;

        public ReturnType_isFullTree(int height, int nodeNum) {
            this.height = height;
            this.nodeNum = nodeNum;
        }
    }

    public static ReturnType_isFullTree process_isFullTree(TreeNode head) {
        if (head == null) return new ReturnType_isFullTree(0, 0);

        ReturnType_isFullTree leftTree = process_isFullTree(head.left);
        ReturnType_isFullTree rightTree = process_isFullTree(head.right);

        //自己的所有信息
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        int nodeNum = leftTree.nodeNum + rightTree.nodeNum;

        return new ReturnType_isFullTree(height, nodeNum);
    }

    //如何判断一颗二叉树是否是平衡二叉树？（二叉树题目套路）
    //左树高度与右树高度差不超过1--> |左树高度 - 右树高度| <= 1
    public static boolean isBalanced(TreeNode head) {
        return process_isBalanced(head).isBalanced;
    }

    public static class ReturnType_isBalanced {
        public boolean isBalanced;
        public int height;

        public ReturnType_isBalanced(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType_isBalanced process_isBalanced(TreeNode head) {
        if (head == null) return new ReturnType_isBalanced(true, 0);


        ReturnType_isBalanced leftTree = process_isBalanced(head.left);
        ReturnType_isBalanced rightTree = process_isBalanced(head.right);


        //根节点树的高度为左子树和右子树的高度的最大值加一
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        //判断是否为搜索树,1.左子树和右子树都是搜索树,左子树和右子树高度差<=1
        boolean isBalanced = (leftTree.isBalanced && rightTree.isBalanced)
                && Math.abs(leftTree.height - rightTree.height) < 2;
        //返回这个数的所有信息
        return new ReturnType_isBalanced(isBalanced, height);
    }

    //给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.拿到所有节点所定义的父节点,要找到一个节点的整条链,就可以这样做
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        process(root, fatherMap);

        //2.通过o1一直往上遍历,将o1的整条链存放到hashSet中
        HashSet<TreeNode> hashSet = new HashSet<>();
        TreeNode cur = p;
        while (cur != fatherMap.get(cur)) {
            hashSet.add(cur);
            //遍历的依据
            cur = fatherMap.get(cur);
        }
        hashSet.add(root);

        for (TreeNode node : hashSet) {
            System.out.print(node.val + " ");
        }
        System.out.println();
        //3.遍历o2整条链,如果发现其中一个节点存在于hashSet中,就返回这个节点
        cur = q;
        while (cur != fatherMap.get(cur)) {
            if (hashSet.contains(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return root;
    }

    public static void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap) {
        if (root == null) return;
        //根是根的左孩子和右孩子的父节点
        if (root.left != null) {
            fatherMap.put(root.left, root);
        }
        if (root.right != null) {
            fatherMap.put(root.right, root);
        }
        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }

    /*
    p,q两种情况:
    1).各在一侧,返回head
    2).都在一侧,只要遇到其中一个,就返回,就是他们的最近祖先节点
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor1(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor1(root.right, p, q);

        //1).各在一侧,返回head
        if (leftTree != null && rightTree != null) {
            return root;
        }
        //2).都在一侧,只要遇到其中一个,就返回,就是他们的最近祖先节点
        return leftTree != null ? leftTree : rightTree;
    }

    /*
    现在有一种新的二叉树节点类型如下:
public class Node {
public int value;
public Node left;
public Node right;
public Node parent;
public Node(int val) {
value = val;
}
}
该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己的父节点，头节
点的parent指向null。
只给一个在二叉树中的某个节点node，请实现返回node的后继节点的函数。
在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
     */
    /*
    1.x有右树的时候,x的后继节点为右树的最左节点
    2.x无右树的时候,
     */

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            value = val;
        }
    }

    public static Node inorderSuccessor1(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            return process_inorder(node.right);
        } else {
            Node parent = node.parent;
            //循环的条件是这个节点不是父节点的左节点
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node process_inorder(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //序列化
    public static String serialByPre(TreeNode root) {
        if (root == null) return "#_";

        String string = root.val + "_";
        string += serialByPre(root.left);
        string += serialByPre(root.right);
        return string;
    }

    //反序列化
    public static TreeNode reconByPreString(String string) {
        String[] str = string.split("_");
        Queue<String> list = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        TreeNode head = process_recon(list);
        return head;
    }

    private static TreeNode process_recon(Queue<String> list) {
        String value = list.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = process_recon(list);
        node.right = process_recon(list);

        return node;
    }

    //折纸问题,就是中序遍历,每一颗左子树为凹,每一颗右子树为凸
    public static void printAllFolds(int N) {
        PaperFolding(1, N, true);
    }

    //i:节点的层数,N:层数,down--true 凹,down--false 凸
    public static void PaperFolding(int i, int n, boolean down) {
        if (i < n) return;
        //左节点都为凹
        PaperFolding(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        //右节点都为凸
        PaperFolding(i + 1, n, false);
    }
}

/*
可以通过向左树,右树要信息就解决,就可以用DP套路
树形DP(动态规划),递归套路,要求就要相同,信息要全集(所有需要信息的集合)
 */
