package Queue;

public class LinkedList implements Deque {
    //内部类
    private static class Node {
        private Integer v;
        Node previous;
        Node next;

        Node(Integer x) {
            v = x;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //头插
    @Override
    public boolean offerFirst(Integer e) {
        if (this.size==0) {
            this.head=this.tail=new Node(e);
        }else{
            Node node = new Node(e);
            node.next=this.head;
            this.head.previous=node;
            this.head=node;
        }
        this.size++;
        return true;
    }

    //看头上的值
    @Override
    public Integer peekFirst() {
        if (this.size==0) {
            return null;
        }
        return this.head.v;
    }

    //看头上的值,并删除
    @Override
    public Integer pollFirst() {
        if (this.size==0) {
            return null;
        }
        Integer v = this.head.v;
        this.head=this.head.next;
        //不只是一个节点,切断所有对于之前head的引用
        if (this.head!=null) {
            this.head.previous=null;
        }else{
            //没有接点了,切断tail对于之前head的引用
            this.tail=null;
        }
        this.size--;
        return v;
    }

    //尾插
    @Override
    public boolean offerLast(Integer e) {
        if (this.size==0) {
            this.head=this.tail=new Node(e);
        }else {
            Node node = new Node(e);
            node.previous=this.tail;
            this.tail.next=node;
            this.tail=node;
        }
        this.size++;
        return true;
    }

    //看尾部的值
    @Override
    public Integer peekLast() {
        if (this.size==0) {
            return null;
        }
        return this.tail.v;
    }

    //看尾部的值,并删除
    @Override
    public Integer pollLast() {
        if (this.size==0) {
            return null;
        }
        Integer v = this.tail.v;
        this.tail=this.tail.previous;
        if (this.tail==null) {
            this.head=null;
        }else {
            this.tail.next=null;
        }
        this.size--;
        return v;
    }
}
