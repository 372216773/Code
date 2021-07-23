package DoubleLinkedList;

public class Main {

    public static void main(String[] args) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(6);
        list.addLast(12);
        list.addFirst(3);
        list.addFirst(12);
        list.addFirst(12);
        list.addFirst(12);
        list.addIndex(3,12);
        list.display();
        list.removeAllKey(12);
        list.display();
    }
}
