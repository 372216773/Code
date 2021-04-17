package Queue;

import java.util.NoSuchElementException;

public interface Deque extends Queue{
    //这组方法,通过特殊值来报告错误
    //头部添加元素
    boolean offerFirst(Integer e);
    //获取头部元素,不删除
    Integer peekFirst();
    //获取头部元素,并删除
    Integer pollFirst();

    //尾部添加元素
    boolean offerLast(Integer e);
    Integer peekLast();
    Integer pollLast();

    //这组方法,通过异常报错
    //first
    default void addFirst(Integer e) {
        if (offerFirst(e)==false) {
            throw new IllegalStateException();
        }
    }
    default Integer getFirst() {
        Integer e = peekFirst();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeFirst() {
        Integer e=pollFirst();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    //last
    default void addLast(Integer e) {
        if (offerLast(e)==false) {
            throw new IllegalStateException();
        }
    }
    default Integer getLast() {
        Integer e=peekLast();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeLast() {
        Integer e=pollLast();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    //这组方法,继承自Queue,重写方法
    //以特殊值的形式报告错误
    //添加元素(尾部)
    default boolean offer(Integer e) {
        return offerLast(e);
    }
    //获取元素,不删除
    default Integer peek() {
        return peekFirst();
    }
    //获取元素,并删除
    default Integer poll() {
        return pollFirst();
    }

    //下边这组方法为栈的形态做准备,包括上边peek()方法
    default void push(Integer e) {
        addFirst(e);
    }
    default Integer pop() {
        return removeFirst();
    }

}
