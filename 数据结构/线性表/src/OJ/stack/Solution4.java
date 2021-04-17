package OJ.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否可能表示为该栈的弹出顺序
//多用list,少用数组
public class Solution4 {

    public List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        List<Integer> pushList = intArrayToList(pushA);
        List<Integer> popList = intArrayToList(popA);
        //栈
        Deque<Integer> stack = new LinkedList<>();
        //popA中元素不为空
        while (!popList.isEmpty()) {
            //取出popA中的第一个元素
            int p = popList.remove(0);
            while (true) {
                //如果栈是空的或者栈顶元素与p不相等
                if (stack.isEmpty() || stack.peek().intValue() != p) {
                    //如果pushA空了,返回false
                    if (pushList.isEmpty()) {
                        return false;
                    }
                    Integer q = pushList.remove(0);
                    stack.push(q);
                } else {
                    break;
                }
            }
            //弹出栈顶元素
            stack.pop();
        }
        return stack.isEmpty();
    }

}
