package com.wj.designPrinciple.composite;

import java.util.Collection;
import java.util.HashSet;

/*
制作一个集合,要求该集合能记录曾经加过多少个元素(不是统计某一事件集合中有多少元素)
 */
class MySet{
    //统计个数
    private int count=0;

    HashSet hashSet = new HashSet();

    public boolean add(Object o) {
        count++;
        return hashSet.add(o);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        //调用的是hashSet中的add()
        return hashSet.addAll(c);
    }

    public int getCount() {
        return count;
    }
}

public class Resolve_composite {
}
/*
为了解决上述问题,修改代码如下:
1.不再去继承HashSet
2.取而代之的,我们让MySet和HashSet发生关联中的组合关系

 1.没有继承HashSet,没有重写HashSet中的方法,所以不会造成其他方法依赖于add()和addAll()出现问题
 2.当使用MySet类添加元素时,HashSet中新的添加元素的方法MySet不会有,
    MySet中只有两个方法,就不会出现统计时漏掉个数的问题
 3.当HashSet中新的添加元素的方法与MySet类中添加元素的方法名相同,也不会出现问题

 这样做就是做了一个壳子,内部还是调用的HashSet的方法,但不会出现继承所带来的问题
 */