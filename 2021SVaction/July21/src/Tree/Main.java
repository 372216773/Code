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

        System.out.println(binaryTree.find(root, 'd').val);

        binaryTree.preOrderTraversalNor(root);
        System.out.println();
        binaryTree.inOrderTraversalNor(root);
        System.out.println();
        binaryTree.postOrderTraversalNor(root);

        //构造二叉树
        String string = "abc##de##g##f###";
        BTNode root1 = BinaryTree.createBinaryTree(string);
        binaryTree.preOrderTraversal(root1);



    }
}
