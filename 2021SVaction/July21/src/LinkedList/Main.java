package LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createLinked();
        myLinkedList.display();
        Node tailNode = myLinkedList.findTailNode();
        System.out.println(tailNode.val);
        System.out.println("链表大小:\t" + myLinkedList.size());
        System.out.println(myLinkedList.contains(7));
        myLinkedList.addLast(7);
        myLinkedList.display();
        myLinkedList.addHead(0);
        myLinkedList.display();
        System.out.println(myLinkedList.findTailNode().val);
        myLinkedList.addIndex(8,44);
        myLinkedList.display();
        System.out.println(myLinkedList.findLastTwoNode().val);
        System.out.println(myLinkedList.findN(5).val);
        myLinkedList.remove(5);
        myLinkedList.display();
        myLinkedList.removeAllKey(4);
        myLinkedList.clear();
        myLinkedList.display();
    }
}
