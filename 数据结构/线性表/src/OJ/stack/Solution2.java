package OJ.stack;

import java.util.Deque;
import java.util.LinkedList;

//用栈实现队列的操作
public class Solution2 {

    Deque<Integer> stack;
    Deque<Integer> stack1;

    //构造方法用来初始化
    public Solution2() {
        stack = new LinkedList<>(); //准备出的
        stack1 = new LinkedList<>();//优先放的
    }

    public void push(int x) {
        //无脑压栈
        stack1.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack.push(stack1.pop());
            }
        }
        return stack.pop();
    }

    //只看不取,队首元素
    public int peek() {
        if (stack.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack.push(stack1.pop());
            }
        }
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && stack1.isEmpty();
    }
}
