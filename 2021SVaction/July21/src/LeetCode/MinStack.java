package LeetCode;

import java.util.Stack;

//最小栈
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.empty()) {
            stack2.push(val);
        } else {
            if (val <= stack2.peek()) {
                stack2.push(val);
            }
        }

    }

    public void pop() {
        int val = stack1.pop();
        if (val == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {

    }
}
