package BinaryTree;

public class Main {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode tree = traversal.createTree();
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = Traversal.lowestCommonAncestor(tree, node, node1);
        System.out.println(node2.val);
    }
}
