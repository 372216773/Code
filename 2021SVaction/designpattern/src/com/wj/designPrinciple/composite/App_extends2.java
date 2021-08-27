package com.wj.designPrinciple.composite;

import java.util.Collection;
import java.util.HashSet;

/*
需求:制作一个集合,要求该集合能记录曾经加过多少元素
 */
class MySet2 extends HashSet{
    //统计个数
    private int count=0;
    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        boolean b = false;
        for (Object o : c) {
            //版本更替,如果addAll不再调用add方法,那我们就指定调用add()
            if(add(o)) {
                b = true;
            }
        }
        return b;
    }

    public int getCount() {
        return count;
    }
}

public class App_extends2 {
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
为了解决版本更替,如果addAll不再调用add方法的问题:那我们就指定调用add()
1.此时代码看起来很完美,已经满足需求

    问题:
    1.如果新版本中,HashSet中突然多了一个新的添加元素的方法,我们并没有重写这个新方法,就会导致统计时漏掉通过新方法添加元素的个数,就会出错
    2.并且在HashSet中难免有其他方法依赖于我们重写的方法,我们这样没头没脑的去重写某些方法,就会导致其他方法出错

 */
