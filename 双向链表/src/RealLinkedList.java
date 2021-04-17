class ListNode {
    public int data;
    public ListNode next;
    public ListNode prev;

    public ListNode(int data) {
        this.data=data;
    }
}

public class RealLinkedList {

    public ListNode head;
    public ListNode tail;

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.tail = node;
            this.head = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    //从前往后输出链表
    public void displayNext() {
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //从后往前输出链表
    public void displayPrev() {
        for (ListNode cur = this.tail; cur != null; cur = cur.prev) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        if (!checkIndex(index)) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        //注意修改后的指向发生改变
        cur.prev.next = node;
        cur.prev = node;

    }

    //位置是否合法
    public boolean checkIndex(int index) {
        if (index < 0 || index > size()) {
            return false;
        }
        return true;
    }

    //链表长度
    public int size() {
        int length = 0;
        ListNode cur = this.head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //获取index位置
    public ListNode searchIndex(int index) {
        ListNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    //如果是尾结点,与tail=null效果相同
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        this.tail = cur.prev;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
                //删除完成就返回
                return;
            }
            cur = cur.next;
        }

    }

    //删除所有出现的关键字key
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    //如果是尾结点,与tail=null效果相同
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        this.tail = cur.prev;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //只有引用都置为空,才算删除
    public void clear() {
        ListNode cur = this.head;
        ListNode curNext;
        while (cur != null) {
            curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
        this.tail = null;
    }

    //查找是否包含关键字key在单链表中
    public boolean contains(int key) {
        ListNode cur=this.head;
        while (cur!=null) {
            if (cur.data==key) {
                return true;
            }
        }
        return false;
    }
}
