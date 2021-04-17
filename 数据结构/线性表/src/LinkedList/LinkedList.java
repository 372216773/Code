package LinkedList;

public class LinkedList implements List {

    public Node head;//指向第一个结点
    public Node last;//指向最后一个结点
    public int size;//大小

    @Override
    public boolean add(Integer e) {

        Node node = new Node(e);
        //链表为空
        if (this.size == 0) {
            this.head = this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        this.size++;
        return true;
    }

    //任意位置插入
    @Override
    public void add(int index, Integer e) {

        //下标判断
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        //1.index=0
        if (index == size) {
            //尾插,同时处理链表中有结点和链表中没有结点的情况
            add(e);
        } else if (index == 0) {
            //头插
            Node node = new Node(e);
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            this.size++;
        } else {
            //中间位置的插入
            //找到index-1位置的结点
            Node prev;//用来标识index-1位置
            if (index - 1 < this.size / 2) {
                prev = this.head;
                //从head出发,找到index-1的位置
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
            } else {
                //从last出发,找到index-1的位置
                prev = this.last;
                //一共要跳(size-1)-(index-1)次
                for (int i = 0; i < this.size - index; i++) {
                    prev = prev.prev;
                }
            }
            Node node = new Node(e);
            //prev已经指向index-1位置的下标
            //next指向index位置
            Node next = prev.next;

            node.prev = prev;
            node.next = next;
            prev.next = node;
            next.prev = node;

            size++;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("下标越界");
        }

        int value;
        if (index == 0) {
            //删头结点
            value = this.head.element;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            //可能存在一个结点的情况,删完,链表为空
            if (this.size == 0) {
                //让尾结点引用也不指向待删结点,就会自动被回收
                this.last = null;
            }
        } else if (index == this.size - 1) {
            //删尾结点
            value = this.last.element;
            this.last = this.last.prev;
            this.last.next = null;
            this.size--;
        } else {
            //删中间结点
            Node delNode;
            if (index - 1 < this.size / 2) {
                //据head近
                delNode = this.head;
                for (int i = 0; i < index; i++) {
                    delNode = delNode.next;
                }
            } else {
                delNode = this.last;
                for (int i = 0; i < this.size - index - 1; i++) {
                    delNode = delNode.prev;
                }
            }
            value = delNode.element;
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
            size--;
        }
        return value;
    }

    @Override
    public boolean remove(Integer e) {
        for (Node cur = this.head; cur != null; cur = cur.next) {
            if (cur.element.equals(e)) {
                //是头结点
                if (cur == this.head) {
                    remove(0);
                    return true;
                } else if (cur == this.last) {
                    //删尾结点
                    remove(this.size - 1);
                    return true;
                } else {
                    //删中间结点
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("下标越界");
        }

        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("下标越界");
        }

        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        int value = cur.element;
        cur.element=e;
        return value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head=null;
        last=null;
        this.size=0;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        int count=0;
        for (Node cur=this.head;cur!=null;cur=cur.next,count++) {
            if (cur.element.equals(e)) {
                return count;
            }
        }
        //没有找到
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int count=this.size-1;
        for (Node cur=this.last;cur!=null;cur=cur.prev,count--) {
            if (cur.element.equals(e)) {
                return count;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (Node cur = this.head; cur != null; cur = cur.next) {
            stringBuilder.append(cur.element);
            if (cur != this.last) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();

    }
}
