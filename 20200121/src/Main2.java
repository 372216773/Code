import java.util.Scanner;
/*
输出两个单调递增的链表,输出两个链表合成后的链表,当然我们需要合成后的链表满足单调不减的规则
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head1=new Node(2);
        head1.addLast(3);
        head1.addLast(6);
        head1.addLast(9);
        head1.addLast(323);
        head1.addLast(345);

        Node head2 = new Node(1);
        head2.addLast(2);
        head2.addLast(4);
        head2.addLast(7);
        head2.addLast(8);
        head2.addLast(10);
        head1.AddList(head1,head2);

    }
}
class Node{
    int data;
    Node next;//默认为null
    Node(int data){
        this.data = data;
    }

    Node head=null;
    Node tail=null;

    public void addLast(int data) {
        Node node = new Node(data);
        if (head==null) {
            head=tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    public Node AddList(Node head1,Node head2) {
        Node newHead = new Node(-1);
        return newHead;
    }
}

