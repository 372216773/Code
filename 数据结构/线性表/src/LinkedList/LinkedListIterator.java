package LinkedList;


public class LinkedListIterator implements Iterator{

    //迭代器需要便利的链表
    private LinkedList linkedList;
    //当前节点
    private Node current;

    public LinkedListIterator(LinkedList linkedList) {
        this.linkedList=linkedList;
        this.current=linkedList.head;
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    //1.返回当前结点的值
    //2.结点向下走
    @Override
    public Integer next() {
        int value = current.element;
        current=current.next;
        return value;
    }

    @Override
    public void remove() {
    }
}
