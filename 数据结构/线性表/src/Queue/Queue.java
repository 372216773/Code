package Queue;


import java.util.NoSuchElementException;

//仿造 真正的(java.util.Queue)的Queue接口
public interface Queue {
    //这组方法通过特殊的返回值,通知错误
    //插入true:成功 false:失败 (例如:容量满了)
    boolean offer(Integer e);
    //看队首元素,但不删除,返回null,代表队列是空的
    Integer peek();
    //返回并删除队首元素,返回null,代表队列是空的
    Integer poll();

    //这组方法通过抛出异常,通知错误
    //插入true:成功 false:失败 (例如:容量满了)
    default boolean add(Integer e) {
     if (offer(e)==false) {
         throw new IllegalStateException();
     }
     return true;
    }
    //看队首元素,但不删除
    default Integer element() {
        Integer e =peek();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    //返回并删除队首元素
    default Integer remove() {
        Integer e = poll();
        if (e==null) {
            throw new NoSuchElementException();
        }
        return e;
    }

}
