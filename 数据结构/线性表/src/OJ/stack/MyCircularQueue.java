package OJ.stack;

//设计一个循环队列
/*
循环队列是一种线性结构,其操作表现基于FIFO(先进先出)原则,
并且队尾被连接在队首之后以形成一个循环.它也被称为"环形缓冲器"
循环队列的一个好处是我们利用这个队列之前用过的空间.在一个普通队列中,
一旦一个队列满了,我们就不能插入下一个元素,即使在队列前边仍有空间.但是使用循环队列,
我们能够使用这些空间去存储新的值
支持以下操作:
MyCircularQueue(k): 构造器,设置队列长度为k
Front:从队首获取元素.如果队列为空,返回-1
Rear: 获取队尾元素.如果队列为空,返回-1
enQueue(value): 像循环队列中插入一个元素.如果成功插入则返回真
(frontIndex==rearIndex)
    出现两种情况:
    1.队列已满
    2.队列为空
所以引入size来区分
 */
public class MyCircularQueue {
    private final int[] array;
    private int size;
    private int frontIndex;
    private int rearIndex;

    /**
     * 初始化循环队列
     *
     * @param k 容量
     */
    public MyCircularQueue(int k) {
        //array引用指向一个大小为k的int型数组
        array = new int[k];
        //初始大小为0
        size = 0;
        //队首
        frontIndex = 0;
        //队尾
        rearIndex = 0;
    }

    /**
     * 插入操作
     * 失败(容量满了),返回false
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (size==array.length) {
            return false;
        }
        array[rearIndex]=value;
        size++;
        rearIndex++;
        //rearIndex=(rearIndex+1)%array.length;
        if (rearIndex==array.length) {
            rearIndex=0;
        }
        return true;
    }

    /**
     * 从循环队首删除一个元素
     * @return
     */
    public boolean deQueue() {
        if (size==0) {
            return false;
        }
        //队首向后挪动
        frontIndex++;
        size--;
        return true;
    }

    /**
     * 返回队首元素
     * 失败返回-1
     *
     * @return
     */
    public int Front() {
        if (size==0) {
            return-1;
        }
        return array[frontIndex];
    }

    /**
     * 返回队尾元素
     * 失败返回-1
     *
     * @return
     */
    public int Rear() {
        if (size==0) {
            return -1;
        }

        //rearIndex指向size
        //如果队尾元素为数组的最后一个元素
        int index=rearIndex-1;
        if (index==-1) {
            index=array.length-1;
        }
        return array[index];
    }

    public boolean isFull() {
        return size==array.length;
    }

    public static void main(String[] args) {

    }

}
