package Stack;

//栈:底层是数组
public class MyStack {
    int[] elem;
    int top;

    public MyStack() {
        this.elem = new int[10];
    }

    //移除栈顶元素
    public int pop() {
        if (size() == 0) {
            System.out.println("栈为空");
            return -1;
        }
        return this.elem[this.top--];
    }

    //查看栈顶元素
    public int peek() {
        return this.elem[this.top - 1];
    }

    //添加元素
    public void push(int data) {
        this.elem[this.top ++] = data;

    }

    public int size() {
        return this.top;
    }

    //判断是否为空
    public boolean empty() {
        return size() == 0;
    }

}
