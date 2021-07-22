package LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(3);
        myLinkedList.addLast(2);
        myLinkedList.addLast(1);
        //MyLinkedList myLinkedList1 = new MyLinkedList();
        //Node node = myLinkedList.mergeTwoLists(myLinkedList.head, myLinkedList1.head);
        //myLinkedList.display(node);
        System.out.println(myLinkedList.chkPalindrome());
    }
}
