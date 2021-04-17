package ArrayList;

import ArrayList.ArrayList;

//仿写真实的(java.util.Iterator)接口
//迭代(Iterate)器(or)
public interface Iterator {

    //判断是否有下一个
    boolean hasNext();

    //返回当前元素
    Integer next();


    //删除元素
    void remove();

}
