package Tree;

import java.util.*;

class BTNode {
    char val;
    BTNode left;
    BTNode right;

    public BTNode(char val) {
        this.val = val;
    }

}

public class BinaryTree {

    //用来遍历字符串
    public static int i = 0;

    //创建树🌳
    public BTNode createTree() {
        BTNode A = new BTNode('a');
        BTNode B = new BTNode('b');
        BTNode C = new BTNode('c');
        BTNode D = new BTNode('d');
        BTNode E = new BTNode('e');
        BTNode F = new BTNode('f');
        BTNode G = new BTNode('g');
        BTNode H = new BTNode('h');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    public static BTNode createBinaryTree(String string) {
        if (string == null) return null;
        BTNode root = null;
        if (string.charAt(i) != '#') {
            root = new BTNode(string.charAt(i));
            i++;
            root.left = createBinaryTree(string);
            root.right = createBinaryTree(string);
        } else {
            i++;
        }
        return root;
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

    //非递归
    //前序遍历
    public void preOrderTraversalNor(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        //如果一个结点的left和right都为null,就说明这个节点走完了,开始弹栈,获取到父节点
        while (cur != null || !stack.empty()) {
            //遍历左节点,并打印,遍历完后cur == null
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            //当前cur.left为null,就开始弹栈,获取right的节点,打印存在栈中的父节点的left节点
            BTNode top = stack.pop();
            //走向右节点
            cur = top.right;
        }
    }

    //中序遍历
    public void inOrderTraversalNor(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        //左节点遍历完,存到栈中
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur == null,从栈中取出节点,并打印
            BTNode top = stack.pop();
            System.out.print(top.val + " ");
            //开始遍历右节点
            cur = top.right;
        }
    }

    //后序遍历
    public void postOrderTraversalNor(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //看一下栈顶元素
            BTNode top = stack.peek();

            //终止条件,top的左节点为空,打印top,**top.right == prev**只要打印过的就记为prev,防止在右节点死循环
            if (top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.val + " ");
                prev = top;
            } else {
                //如果右节点不为空,就遍历右子树
                cur = top.right;
            }
        }
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
    public BTNode find(BTNode root, char val) {
        if (root == null) return null;

        //根
        if (root.val == val) {
            return root;
        }

        //左子树
        BTNode leftNode = find(root.left, val);
        //得到返回值,不为null说明找到了,返回
        if (leftNode != null) {
            return leftNode;
        }

        //右子树
        BTNode rightNode = find(root.right, val);
        //得到返回值,不为null说明找到了,返回
        if (rightNode != null) {
            return rightNode;
        }

        //没有找到
        return null;
    }

    //判断两棵树是否相同
    public boolean isSameTree(BTNode p, BTNode q) {
        if (p == null || q == null) return false;

        //根
        if (p.val != q.val) return false;

        //左子树
        isSameTree(p.left, q.left);

        //右子树
        isSameTree(p.right, q.right);

        return true;
    }

    //层序遍历
    public List<List<Character>> levelOrder(BTNode root) {
        List<List<Character>> list = new ArrayList<>();

        if (root == null) return list;
        //队列
        Queue<BTNode> queue = new LinkedList<>();

        //最开始有一个节点值
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Character> list1 = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                //cur用于遍历
                BTNode cur = queue.poll();
                //
                list1.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            list.add(list1);
        }
        return list;
    }

    //判断是否是完全二叉树
    public boolean isCompleteTree(BTNode root) {
        //队列:先进先出
        Queue<BTNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.offer(root);
        while (true) {
            //遍历 a|b c|
            BTNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        //当cur等于null时,就是走到了最后一个节点,此队列中就应该只剩下null
        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;

    }

    //如何判断一颗二叉树是否是搜索二叉树？(搜索二叉树:每一颗左子树都比他小,右子树都比他大)
    public static int preValue = Integer.MIN_VALUE;
    //递归
    public static boolean isBSTree(BTNode head) {
        if (head == null) return true;
        boolean isLeftBst = isBSTree(head.left);
        if (!isLeftBst) return false;
        if (head.val <= preValue) return false;
        //到这的值分别为左值,根值,右值
        preValue = head.val;
        return isBSTree(head.right);
    }
    //非递归
    public static boolean isBSTreeUnRecur(BTNode head) {
        if (head == null) return false;
        int preValue = Integer.MIN_VALUE;
        Stack<BTNode> stack = new Stack<>();
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



}
