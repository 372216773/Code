package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTestCase {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.size());
        /*System.out.println(queue.element());
        System.out.println(queue.element());*/
        //删除队首元素
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }

}
