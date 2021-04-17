package LinkedList;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
//单向循环链表
public class Demo {
    Node head;
    //记录尾结点
    Node tail;

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            this.head = this.tail = node;
        }
        node.next = this.head;
        this.head = node;
        this.tail.next = this.head;
    }

    public void display() {
        Node p=this.head;
        while(p!=null) {
            System.out.println(p.value);
            p=p.next;
        }
    }

    public int del() {
        Node pf=null;
        Node p=this.head;
        int count=0;
        while(this.head.next!=this.head) {
            count++;
            if (count%3==0) {
                count=0;
                if (p==this.head) {
                    this.head=this.head.next;
                }
                pf.next=p.next;
            }
            pf=p;
            p=p.next;
        }
        return this.head.value;
    }
}

