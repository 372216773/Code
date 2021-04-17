package ArrayList;

import java.util.Arrays;

//仿写真实的(java.util.ArrayList)实现类
public class ArrayList implements List<Number> {

    //内置数组
    private int[] array;//array默认值为null

    //元素个数
    private int size;

    public ArrayList() {
        //给array赋初值,初始容量为10个
        this.array = new int[10];
        //size赋初值,初始大小为0个
        this.size = 0;
    }

    //复制other线性表
    public ArrayList(List<Number> other) {

        //使array的容量等于other的大小
        array = new int[other.size()];
        //将other的值赋给array
        for (int i = 0; i < other.size(); i++) {
            array[i] = other.get(i);
        }
        //使array的大小等于other
        size = other.size();
    }

    @Override
    public boolean add(Integer e) {
        //扩容为二倍
        if (array.length == this.size) {
            ensureCapacity(this.array.length * 2);
        }
        this.array[this.size++] = e;
        return true;
    }

    //扩容O(n)
    //调用完这个方法,保证容量一定>=capacity,capacity是自己定义的大小
    public void ensureCapacity(int capacity) {

        //1.检查是否需要扩容,如果原本容量就大于自己定义的大小,就不必扩容
        if (this.array.length >= capacity) {
            System.out.println("当前容量为: " + this.size() + "不必扩容");
            return;
        }

        //2.定义新的数组
        int[] newArray = new int[capacity];

        //3.将数据从array搬到newArray
        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }

        //4.array引用指向新的数组
        this.array = newArray;
        System.out.println("已成功扩容,当前容量为: " + capacity);
    }

    @Override
    public void add(int index, Integer e) {
        //1.合法性校验 [0,size]
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("不合法下标:" + index);
        }
        //如果此时数组已经被填满,就进行扩容
        if (this.array.length == this.size) {
            ensureCapacity(this.array.length * 2);
        }
        /*
        1.i=index  遍历区间(index,size]
        2.i=index-1  遍历区间[index,size)
        从后往前遍历(保证元素不会被覆盖)
        */
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = e;
        this.size++;

    }

    @Override
    public Integer remove(int index) {

        //合法性判断 [0,size-1]
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不合法下标:" + index);
        }

        //记录删除的元素
        int e = array[index];

        //覆盖要删除的元素
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                remove(i);
                //删除成功
                return true;
            }
        }
        //删除失败
        return false;
    }

    @Override
    public Integer get(int index) {

        //合法性判断
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不合法下标:" + index);
        }

        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        //合法性判断
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不合法下标:" + index);
        }
        //原来的元素
        Integer old = array[index];
        array[index] = e;
        //返回原来位置上的元素
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //-1代表无效值
        Arrays.fill(array, -1);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    //查找指定元素的位置
    @Override
    public int indexOf(Integer e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        //那就从后往前判断
        for (int i = size - 1; i > 0; i--) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {

        StringBuilder stringBuffer = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            stringBuffer.append(this.array[i]);
            if (i != this.size - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public Iterator iterator() {
        //返回Iterator接口的实现类的对象
        return new ArrayListIterator(this);
    }

}
