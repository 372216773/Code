package Stack;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Stack {

    Node head;
    //入栈
    public void push(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head=node;
        }
        
    }

    //出栈
    public void pop() {

    }

    //获得栈顶元素
    public int getTopValue() {
        return 1;
    }

    //
    public void display() {

    }

    //

}
