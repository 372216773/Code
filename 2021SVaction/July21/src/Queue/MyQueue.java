package Queue;

//队列:单链表头出,尾进

class Node {
    public int val;
    public Node next;
    public Node(int data) {
        this.val = data;
    }
}
public class MyQueue {

    //头
    public Node first;
    //尾
    public Node last;

    //队尾添加元素
    public boolean offer(int data) {
        Node node = new Node(data);
        if (this.first == null) {
            this.first = this.last = node;
        } else {
            this.last = this.last.next = node;
        }
        return true;
    }

    public boolean isEmpty() {
        return this.last == null && this.first == null;
    }

    //弹出元素,队首
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int data = this.first.val;
        this.first = this.first.next;
        return data;
    }

    //查看队首元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.first.val;
    }

}
