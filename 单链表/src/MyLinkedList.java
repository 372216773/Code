/* @Title
 * @Description 一个结点
 * @Param
 * @return
 * @Author WJ
 * @Date 19:38 2021/1/3
 */
class Node {
    public int data;//保存结点的数据
    public Node next;//保存结点的引用(地址),构建一个结点时,不知道后一个结点的地址,所以就是null
    public Node(int data) {//构造方法
        this.data=data;
    }
}
public class MyLinkedList {
    Node head;
    //Node tail;//可以不用

    //头插
    public void addFirst(int data) {
        Node node = new Node(data);
        /*if (this.head==null) {
            this.head=node;
            //head.next=null;没必要,初始时就没赋值,即为null
        }else{
        node.next=this.head;
        this.head=node;}*/
        /* @Title
         * @Description 错误代码,会造成死循环,
         * @Param
         * @return void
         * @Author WJ
         * @Date 20:33 2021/1/3
         */
        /*if (this.head==null) {
            this.head=node;//head指向node
        }
        node.next=this.head;//node.next又指向head,
        会造成最后一个结点的next域存着这个节点的地址造成死循环
        this.head=node;
        */
        node.next = this.head;//此时head是null;
        this.head = node;
    }

    //尾插
    public void addLast(int data) {
        Node cur;
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            for (cur = head; cur.next != null; cur = cur.next) ;//找尾结点
            cur.next = node;
        }
    }

    //输出链表
    public void display() {
        for (Node cur = this.head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //输出任意链表
    public static void displayWithHeadNode(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        if (!this.checkIndex(index)) {
            return;
        }//判断位置是否合法

        Node node = new Node(data);
        if (index == 0) {//头插
            this.addFirst(data);

        } else if (index == this.getLength()) {//尾插
            this.addLast(data);//尾插的操纵与下边的操作相同

        } else {//中间位置插入
            Node cur = this.searchPrev(index);//插入元素返回前驱
            node.next = cur.next;//先挂后边,防止丢失
            cur.next = node;//挂前驱
        }
    }

    //判断插入位置是否合法
    public boolean checkIndex(int index) {
        if (index < 0 || index > this.getLength()) {
            System.out.println("下标不合法!");
            return false;
        }
        return true;
    }

    //查找index前驱元素
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;//返回前驱引用
            }
            cur = cur.next;
        }
        return null;//没有找到
    }

    //查找index-1位置
    public Node searchPrev(int index) {
        Node cur = this.head;
        int count = 0;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //链表长度
    public int getLength() {
        Node cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) return;//判断是否为空链表
        if (this.head.data == key) {//删除节点是头结点
            this.head = this.head.next;
            return;
        }
        Node cur = searchPrevNode(key);
        if (cur != null) {//删在尾结点,和中间节点的key
            cur.next = cur.next.next;
        } else {
            System.out.println("没有该节点!");
        }
    }

    //是否包含此元素
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除所有关键字key的节点
    public void removeAllKey1(int key) {
        if (this.head == null) return;
        while (this.contains(key)) {
            remove(key);//删除关键字为key的结点
        }
    }

    //删除所有值为key的节点,只遍历一次链表,双引用联动
    public void removeAllKeyPlus(int key) {
        Node pre = this.head;
        Node cur = pre.next;
        if (this.head == null) return;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        /*这是错过的可能要删除的第一个节点
        放在这,减少要判断的次数
        */
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    /*删除此链表
    当无指向时,会被回收
     */
    //删除此链表
    public void clear() {
        this.head = null;
    }

    /* @Title
     * @Description 三引用联动
     * Node pre = null;//当前需要反转的结点的前驱
        Node cur = this.head;//当前需要反转的结点
        Node curNext;
     * @Param []
     * @return Node
     * @Author WJ
     * @Date 17:27 2021/1/4
    */
    //反转链表
    public Node reverseList() {
        Node pre = null;//当前需要反转的结点的前驱
        Node cur = this.head;//当前需要反转的结点
        Node curNext;
        Node newHead = null;//新链表头结点
        while (cur != null) {
            curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
    }

    //链表中间节点,只允许遍历一遍,快慢引用
    public Node middleNode() {
        if (this.head == null) return null;
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            //while (fast.next != null && fast != null)//会出现空指针异常
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入一个链表,输出链表中倒数第k个结点,快慢指针,且判断输入的大小是否合法,只允许遍历一遍链表
    // slow与fast隔k-1个
    public Node findKthToTail(int k) {
        if (k <= 0 || head == null) {//范围不合法,链表为空情况考虑
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k - 1 > 0) {//确定fast位置,并且包含k值过大的情况
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("K值过大");
                return null;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //以x为基准,所有小于x的结点排在所有大于或等于x的结点之前
    public Node partition(int key) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < key) {
                if (beforeStart == null) {
                    beforeStart = beforeEnd = cur;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = cur;
                }
            } else {
                if (afterStart == null) {
                    afterStart = afterEnd = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = cur;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        if (afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }

    //一个排好序的单链表,删除所有重复的结点,遍历一遍
    public Node deleteDuplication() {
        Node cur = this.head;
        Node newHead = new Node(-1);//表示作用
        Node tmp = newHead;
        while (cur != null) {
            //cur.next!=null,防止空指针异常
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = cur;
                cur = cur.next;
            }
            cur = cur.next;
        }
        tmp.next = null;//最后一个结点置null
        return newHead.next;//tmp结点
    }

    /*
     判断特殊情况:如果为空,返回null:只有一个节点,返回true
     1.找中间节点-->快慢指针
     2.反转-->反转链表截止到中间节点
     3.判断data是否相等(判断是否具有回文结构),两个指针,一个从前走,一个从后走,直到相遇
     **空指针注意**
     */
    //判断链表是否为回文结构
    public boolean chkPalindrome() {
        //空链表
        if (this.head == null) {
            return false;
        }
        //只有一个节点
        if (this.head.next == null) {
            return true;
        }
        //快慢指针找中间节点
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后段链表slow~~null
        Node cur = slow.next;
        Node curNext;
        while (cur != null) {
            curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //判断是否为回文结构
        Node before = this.head;
        Node after = slow;
        while (before != after) {
            if (before.data != after.data) {
                return false;
            }
            //考虑偶数的情况
            if (before.next == after) {
                return true;
            }
            before = before.next;
            after = after.next;
        }
        return true;
    }

    /* 操场跑圈,一个快,走两步,一个慢走一步,总会相遇.
     一个走三步,一个走一步,有可能快,有可能慢,也有可能不相遇
     */
    //判断链表是否为环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            //先走在判断,否则fast==slow条件就直接成立了
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //给定一个链表,返回链表开始入环的第一个节点.如果链表无环,则返回null
    public Node detectCycle() {
        Node slow = this.head;
        Node fast = this.head;
        //找到相遇位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //无环
        if (fast == null || fast.next == null) {
            return null;
        }
        //slow从头结点走到入环点处的路程==fast在环内走到入环点处的路程
        slow = this.head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //创建相交链表
    public static void createCut(Node nodeA, Node nodeB) {
        nodeA.next.next = nodeB.next.next;
    }

    //相交链表
    //两个链表相交,表示的是两个链表的next域指向同一个地址
    // 只有可能是Y型的,x型不可能,因为x相交,相交的结点不可能存两个地址
    //长的链表走完差值,在于短链表一起走找共同指向的节点就是交点
    public static Node getIntersectionNode0(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node nodeA = headA;
        Node nodeB = headB;
        Node nodeA1 = headA;
        Node nodeB1 = headB;
        //先让短的走完
        while (nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        //nodeA长,nodeA没走完,让nodeA1从原点开始走差值
        if (nodeA != null) {
            while (nodeA != null) {
                nodeA = nodeA.next;
                nodeA1 = nodeA1.next;
            }
            //将短的挪回头结点
            nodeB = headB;
            while (nodeA1 != null && nodeB != null && nodeA1 != nodeB) {
                nodeA1 = nodeA1.next;
                nodeB = nodeB.next;
            }
            if (nodeB != null && nodeA1 != nodeB) {
                return nodeB;
            }
            return null;
        }
        //nodeB长,nodeB没走完,让nodeB1从原点开始走差值
        else {
            while (nodeB != null) {
                nodeB = nodeB.next;
                nodeB1 = nodeB1.next;
            }
            //将短的挪回头结点
            nodeA = headA;
            while (nodeB1 != null && nodeA != null && nodeB1 != nodeA) {
                nodeB1 = nodeB1.next;
                nodeA = nodeA.next;
            }
            if (nodeA != null && nodeB1 != nodeA) {
                return nodeA;
            }
            return null;
        }
    }

    //找到两个单链表相交的起始节点
    public static Node getIntersectionNodePlus(Node headA, Node headB) {
        //如果任意链表为空,返回null
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        Node pLong = headA;
        Node pShort = headB;

        //获得链表A的长度
        while (pLong != null) {
            lenA++;
            pLong = pLong.next;
        }
        //获得链表B的长度
        while (pShort != null) {
            lenB++;
            pShort = pShort.next;
        }
        //执行完后pLong,pShort都指向null
        //将pLong,pShort挪回头结点
        pLong = headA;
        pShort = headB;

        //令pLong指向较长链表,pShort指向较短链表
        int len = lenA - lenB;
        if (len < 0) {
            pLong = headB;
            pShort = headA;
            //长度为正
            len = -len;
        }

        //长的链表先走完差值,与短的链表一同到达相交点
        while (len > 0) {
            pLong = pLong.next;
            len--;
        }

        //1.可能pShort到null都没找到相交点
        //2.找到相交点
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        //pLong和pShort指向同一节点
        //pLong和pShort指向null也相等,所以要加条件pLong!=null或者pShort!=null
        if (pLong == pShort && pLong != null) {
            return pLong;
        }
        return null;
    }

    //合并两个有序链表
    public static Node mergeTwoLists(Node headA,Node headB) {
        //傀儡节点
        Node newHead = new Node(-1);
        Node tmp = newHead;

        //走完一个较短的链表,剩下长的那一段为有序链表
        while (headA != null && headB != null) {
            if (headA.data > headB.data) {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            } else {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }
        }
        //链表A较长,剩下的数据都是大于已建好的链表
        if (headA != null) {
            tmp.next = headA;
        }
        //链表B较长,剩下的数据都是大于已建好的链表
        if (headB != null) {
            tmp.next = headB;
        }
        //newHead为傀儡节点,应返回next结点
        return newHead.next;
    }
}

