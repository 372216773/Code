package LinkedList;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
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
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //倒数第二个节点
    public Node findLastTwoNode() {
        if (this.head == null || this.head.next == null) {
            System.out.println("你没有1个以上的节点");
        }
        Node cur = this.head;
        while (cur.next.next != null) {
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
        if (index < 0 || index > size()) {
            System.out.println("位置不合法");
            return;
        }
        int count = 0;
        Node cur = this.head;
        Node curPrev = null;
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
            curPrev.next = newNode;
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

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
        }
        if (contains(key)) {
            if (this.head.val == key) {
                this.head = this.head.next;
            } else {
                Node cur = this.head;
                Node curPrev = null;
                while (cur.val != key) {
                    curPrev = cur;
                    cur = cur.next;
                }
                curPrev.next = cur.next;
            }
        } else {
            System.out.println("不包含该节点");
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        if (contains(key)) {
            Node curPrev = null;
            Node cur = this.head;
            while (cur != null) {
                if (this.head.val == key) {
                    this.head = this.head.next;
                    cur = this.head;
                } else {
                    if (cur.val == key) {
                        curPrev.next = cur.next;
                    } else {
                        curPrev = cur;
                    }
                    cur = cur.next;
                }
            }
        } else {
            System.out.println("没有此节点");
        }
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
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
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    //清空链表
    public void clear() {
        this.head = null;
    }

    //反转链表
    public void reverseList() {
        if (this.head == null) {
            System.out.println("链表为空!");
            return;
        }

        Node curPrev = null;
        Node cur = this.head;
        Node curNext;

        while (cur != null) {
            curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
    }

    //找中间节点
    public Node middleNode() {
        if (this.head == null) {
            System.out.println("链表为空");
        }
        Node slow = this.head;
        Node fast = this.head;

        //条件都必须满足
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //链表中倒数第K个节点,遍历一遍    1.长度 - K    2.快慢指针,两指针相差K - 1步
    public Node FindKthToTail(int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node slow = this.head;
        Node fast = this.head;
        while (--k != 0) {
            //fast.next == null说明已经走到了最后一个结点
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //合并两个有序链表为有序链表,需要傀儡节点,作为引子,在后边接上2个链表的节点
    public Node mergeTwoLists(Node head1, Node head2) {
        Node newHead = new Node(-1);
        Node tmp = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tmp.next = head1;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (head1 == null) {
            tmp.next = head2;
        }
        if (head2 == null) {
            tmp.next = head1;
        }
        return newHead.next;
    }

    //给定一个值K,将小于K的数放到左边,且不改变原链表的顺序
    public Node partition(int x) {
        if (this.head == null) {
            System.out.println("链表为空");
        }
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;

        while (cur != null) {
            if (cur.val < x) {
                if (beforeStart == null) {
                    beforeStart = beforeEnd = cur;
                } else {
                    beforeEnd = beforeEnd.next = cur;
                }
            } else {
                if (afterStart == null) {
                    afterStart = afterEnd = cur;
                } else {
                    afterEnd = afterEnd.next = cur;
                }
            }
            cur = cur.next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;

        //将后一段的链表尾结点的next置为null
        if (afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }

    //删除有序链表中重复节点
    public void deleteRe() {
        Node curPrev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (curPrev.val == cur.val) {
                while (cur != null && curPrev.val == cur.val) {
                    cur = cur.next;
                }
            }
            curPrev.next = cur;
            curPrev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }
    }

    //回文结构 1 -> 2321
    public boolean chkPalindrome() {
        if (this.head == null) {
            System.out.println("链表为空");
            return false;
        }
        //1.找到中间位置
        Node slow = this.head;
        Node fast = this.head;
        //只要不满足一个条件,就说明找到了中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.逆置后半段链表
        Node curPrev = slow;
        Node cur = slow.next;
        Node curNext;
        while (cur != null) {
            curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }

        //slow到了最后一个结点的位置上
        //3.判断
        while (head != slow) {
            if (head.val != fast.val) {
                return false;
            }
            head = head.next;
            fast = fast.next;
        }
        return true;
    }

    //判断连个链表是否相交:差值
    //1.找差值
    //2.长的先走差值
    //3.一起走
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;
        Node pl = headA;
        Node ps = headB;

        while (pl != null) {
            pl = pl.next;
            lenA++;
        }
        while (ps != null) {
            ps = ps.next;
            lenB++;
        }

        pl = headA;
        ps = headB;

        int len = lenA - lenB;

        if (len < 0) {
            pl = headB;
            ps = headA;
            len = -len;
        }

        while (len != 0) {
            pl = pl.next;
            len--;
        }

        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    //判断链表是否有环:快慢指针,一起出发,跑圈快的总会再次遇到慢的
    //快的一次走两步,慢的一次走一步,如果是3步,4步.可能会错过
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //返回链表入环第一个节点
    public Node detectCycle(Node head) {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = this.head;
                while (fast == slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    //删除中间节点
    //删除中间某个节点(既不是第一个节点,也不是最后一个节点),只能访问这个节点
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //
    public Node rotateRight(Node head, int k) {
        if (head == null || k < 0) return null;
        Node fast = head;
        Node slow = head;
        while (k-- != 0) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }

        //在头位置,说明不用移动
        if (fast == slow) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
}


