package ArrayList;

import java.util.Arrays;

//实现顺序表
public class MyArrayList {

    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[5];
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }

    //打印顺序表
    public void display() {
        if (this.usedSize == 0) {
            System.out.println("数组为空");
            return;
        }

        for (int cur : this.elem) {
            System.out.print(cur + "\t");
        }
        System.out.println();
    }

    //判断数据是否已满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //在pos(指定位置)新增元素
    public void add(int pos, int data) {
        //1.数组已满,进行扩容
        if (isFull()) {
            reSize();
        }
        //2.位置非法
        if (pos > this.usedSize || pos < 0) {
            System.out.println("位置非法,请重新输入!");
            return;
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //扩容
    public void reSize() {
        this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
    }

    //尾插
    public void addElement(int data) {
        if (isFull()) {
            reSize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    //头插
    public void addElement1(int data) {
        if (isFull()) {
            reSize();
        }
        for (int i = this.usedSize; i > 0; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[0] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int cur : this.elem) {
            if (cur == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        if (contains(toFind)) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind) {
                    return i;
                }
            }
        }
        return -1;

    }

    //获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    //获取pos位置上的元素
    public int getPos(int pos) {
        return (pos >= 0 && pos < this.usedSize) ? this.elem[pos] : -1;
    }

    //修改pos位置上的元素值为value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("位置非法,请重新输入!");
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("没有该值!");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
