package OJ.stack;

import java.util.Deque;
import java.util.LinkedList;

//设计最小栈(支持push,pop,top操作,并能在常数时间内(时间复杂度O(1),即不能遍历)检索到最小元素的站)
/*
push(x)-->将元素x推入栈中
pop()-->删除栈顶的元素
top()-->获取栈顶元素
getMin()-->检索栈中的最小元素
 */
public class Solution3 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public Solution3() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        //无论什么情况都要压到普通栈中
        stack.push(x);
        //栈是空栈时
        if (stack.isEmpty()) {
            minStack.push(x);
        } else {
            //之前的最小数
            int min = minStack.peek();
            minStack.push(Math.min(x, min));
        }
    }

    public void pop() {
        //相当于更新最小值
        minStack.pop();
        stack.pop();
    }

    //看一下,不修改
    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
