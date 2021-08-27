package BinaryTree;

public class Main {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode node = traversal.createTree();
        System.out.println(Traversal.serialByPre(node));
    }
}
