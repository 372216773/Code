package OJ.stack;

import java.util.LinkedList;
import java.util.Queue;

//使用队列实现栈的操作 解决方法-->先取出来再放回去
/*
队列:
add()
remove()
element()
size()
栈:
push(e)
pop()
peek()
empty()
 */
public class Solution1 {

    private Queue<Integer> queue;

    public Solution1() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size=queue.size();
        //挪size-1个数,留最后一个数来输出
        for (int i = 0; i < size - 1; i++) {
            //取出数
            Integer e = queue.remove();
            //放到后边
            queue.add(e);
        }
        //返回最后一个数
        return queue.remove();
    }

    public int top() {
        int size=queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }
        Integer remove = queue.remove();
        queue.add(remove);
        return remove;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
