package ArrayList;

//仿写真实的(java.util.List)接口
//int 表示下标
//Integer 表示元素
public interface List<I extends Number> extends Iterable {

    //添加元素
    boolean add(Integer e);

    //指定位置插入指定元素
    void add(int index, Integer e);

    //根据下标删除
    Integer remove(int index);

    //删除指定元素
    boolean remove(Integer e);

    //得到指定位置上的元素
    Integer get(int index);

    //将指定位置上的元素修改为指定元素
    Integer set(int index,Integer e);

    //元素个数
    int size();

    //清空表元素
    void clear();

    //判断表是否为空
    boolean isEmpty();

    //判断表是否含有指定元素
    boolean contains(Integer e);

    //返回指定元素的位置
    int indexOf(Integer e);

    //倒序返回指定元素的位置
    int lastIndexOf(Integer e);


}
