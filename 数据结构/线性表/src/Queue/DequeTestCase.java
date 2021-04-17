package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTestCase {

    public static void main(String[] args) {
        Deque<Integer> deque=new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        /*deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        while (!deque.isEmpty()) {
            if (!deque.isEmpty()) {
                System.out.println(deque.getFirst());
            }
            if (!deque.isEmpty()) {
                System.out.println(deque.removeFirst());
            }
            if (!deque.isEmpty()) {
                System.out.println(deque.getLast());
            }
            if (!deque.isEmpty()){
                System.out.println(deque.removeLast());
            }
        }*/
    }

}
