package LinkedList;

public class LinkedListTestCase {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(0,55);
        linkedList.add(4,12);
        linkedList.add(3,34);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);
    }
}
