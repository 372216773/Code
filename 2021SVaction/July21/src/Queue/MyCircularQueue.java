package Queue;

//实现循环队列
class MyCircularQueue {

    int[] elem;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    /**
     * 进栈
     * @param value 值
     * @return 是否成功进栈
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        this.elem[rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    /**
     * 队首
     * @return
     */
    public int Front() {
        if (isEmpty()) return -1;
            return this.elem[this.front];
    }

    /**
     * 队尾
     * @return
     */
    public int Rear() {
        if (isEmpty()) return -1;
        return this.elem[(this.rear +this.elem.length - 1) % this.elem.length];
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 判满
     * @return
     */
    public boolean isFull() {
        return (this.rear + 1) % this.elem.length == this.front;
    }
}