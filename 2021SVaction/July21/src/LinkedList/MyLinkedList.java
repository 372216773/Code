package LinkedList;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(){}
}

public class MyLinkedList {

    public Node head;//头结点

    public void createLinked() {
        this.head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        this.head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    //尾结点
    public Node findTailNode() {
        if (this.head == null) {
            return null;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    //倒数第二个节点
    public Node findLastTwoNode() {
        if (this.head == null ||this.head.next == null) {
            System.out.println("你没有1个以上的节点");
        }
        Node cur = this.head;
        while(cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //头插法
    public void addHead(int data) {
        Node cur = new Node(data);
        cur.next = this.head;
        this.head = cur;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    //找到第n个节点,从1开始
    public Node findN(int n) {
        if (this.head == null) {
            System.out.println("链表为空");
        }
        if (n <= 0 || n >= size()) {
            System.out.println("节点位置输入有误");
        }
        Node cur = this.head;
        int count = 1;  //头结点是第一个节点
        while (count != n) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插入,下标从0开始
    public void addIndex(int index, int data) {
        if (index <0 ||index > size()) {
            System.out.println("位置不合法");
        }
        int count = 0;
        Node cur = this.head;
        Node curPrev;
        Node newNode = new Node(data);

        if (index == 0) {
            addHead(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            while (count != index) {
                curPrev = cur;
                cur = cur.next;
                count++;
            }
            newNode.next = cur;
        }

    }

    //查找是否包含关键字key的节点
    public boolean contains(int key) {
        Node cur = this.head;
        if (this.head == null) {
            System.out.println("链表为空");
        }
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除所有职位key的节点
    public void removeAllKey(int key) {}

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            count ++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表值
    public void display() {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }

    }

    //
    public void clear() {}

}
