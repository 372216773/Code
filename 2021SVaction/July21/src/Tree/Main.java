package Tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println("-------------------");
        binaryTree.inOrderTraversal(root);
        System.out.println("-------------------");
        binaryTree.postOrderTraversal(root);
    }
}
