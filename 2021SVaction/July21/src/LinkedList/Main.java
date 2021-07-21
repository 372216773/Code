package LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createLinked();
        myLinkedList.display();
        Node tailNode = myLinkedList.findTailNode();
        System.out.println(tailNode.val);
        System.out.println(myLinkedList.size());
    }
}
