package DoubleLinkedList;

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyDoubleLinkedList {

    //头结点
    public Node head;
    //尾结点
    public Node last;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = this.last = node;
        } else {
            node.next = this.head;
            this.head = this.head.prev = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = this.last = node;
        } else {
            node.prev = this.last;
            this.last = this.last.next = node;

        }
    }

    //从前往后遍历
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("位置不合法");
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size()) {
            addLast(data);
        }
        Node cur = this.head;
        Node node = new Node(data);

        //插入位置的前驱
        while (--index != 0) {
            cur = cur.next;
        }

        //
        node.next = cur.next;
        cur.next = node;
        //
        cur.next.prev = node;
        node.prev = cur;

    }

    //获取链表长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    //是否包含某个指定元素
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现的关键字为key的节点
    public void remove(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if (cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有关键字为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if (cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    //
    public void clear() {
        Node cur = this.head;
        while(cur != null) {
            Node curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = this.last = null;
    }

}
