package com.wj.designPrinciple.composite;

import java.util.Collection;
import java.util.HashSet;

/*
需求:制作一个集合,要求该集合能记录曾经加过多少元素
 */
class MySet3 extends HashSet{
    //统计个数
    private int count=0;

    public boolean add2(Object o) {
        count++;
        return super.add(o);
    }

    public boolean addAll2(Collection c) {
        boolean b = false;
        for (Object o : c) {
            //版本更替,如果addAll不再调用add方法,那我们就指定调用add()
            if(add2(o)) {
                b = true;
            }
        }
        return b;
    }

    public int getCount() {
        return count;
    }
}

public class App_extends3 {
    public static void main(String[] args) {
        MySet2 mySet = new MySet2();
        mySet.add("麦当");
        mySet.add("迪亚");
        mySet.add("咕咚");
        mySet.add("米龙");
        System.out.println(mySet+"个数: "+ mySet.getCount());
    }
}
/*
为了解决可能会有新的添加元素的方法,并且重写方法可能会导致其他方法出错的问题:
1.我们不再重写添加元素的方法
2.额外制作两个代替旧的添加元素的新方法,add2(),addAll2(),还要在API中说明,当要添加元素的时候,就使用新的方法

此时代码看起来很完美,已经满足需求

    问题:
    1.目前这种改动会对用户适应新版本造成影响
    2.如果在新版本中,HashSet恰好新加入了add2().addAll2(),就又会出现重写的问题

    继承到这里已经尽力了

 */
