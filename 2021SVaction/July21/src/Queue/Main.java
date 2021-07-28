package Queue;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        Node node = queue.first;
        while(node!=null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        node = queue.first;
        while(node!=null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
