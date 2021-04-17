package ArrayList;

import ArrayList.ArrayList;

public class ArrayListIterator implements Iterator{

    //对一个顺序表做迭代,关键是控制下标
    //要进行迭代的顺序表
    private ArrayList arrayList;
    //顺序表的位置
    private int index;

    public ArrayListIterator(ArrayList arrayList) {
        //引用指向被迭代的对象
        this.arrayList = arrayList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index<arrayList.size();
    }

    @Override
    public Integer next() {
        return arrayList.get(index++);
    }

    @Override
    public void remove() {
    }
}
