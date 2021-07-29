package Tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.getSize2(root));

        System.out.println(binaryTree.getLeftSize2(root));
        System.out.println(binaryTree.getKLevelSize(root,2));
        System.out.println(binaryTree.getHeight(root));
    }
}
