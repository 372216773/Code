package LeetCode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//用队列实现栈
public class MyStack {

    private static Queue<Integer> queue1;
    private static Queue<Integer> queue2;

    MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public static void push(int x) {
        //谁不为空,就放到那个队列中
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else if (!queue2.isEmpty()) {
            queue2.add(x);
        } else {
            //都为空时,放到queue1队列中
            queue1.add(x);
        }
    }

    public static int pop() {
        if (empty()) return -1;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

    }

    public static boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static int top() {
        if (empty()) return -1;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            int cur = 0;
            //queue1.size()移除,加入元素队列的大小会实时变化
            for (int i = 0; i < queue1.size(); i++) {
                cur = queue1.poll();
                queue2.add(cur);
            }
            return cur;
        } else {
            int size = queue2.size();
            int cur = 0;
            for (int i = 0; i < queue2.size(); i++) {
                cur = queue2.poll();
                queue1.add(cur);
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        push(1);
        push(2);
        System.out.println(top());
        Stack<Object> stack = new Stack<>();

    }
}
