package com.wj.designPrinciple.composite;

import java.util.Collection;
import java.util.HashSet;
/*
需求:制作一个集合,要求该集合能记录曾经加过多少元素
 */
class MySet1 extends HashSet{
    //统计个数
    private int count=0;
    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        //因为addAll底层用的也是add,所以不用再addAll中count++
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }
}
public class App_extends1 {
    public static void main(String[] args) {
        MySet1 mySet = new MySet1();
        mySet.add("麦当");
        mySet.add("迪亚");
        mySet.add("咕咚");
        mySet.add("米龙");
        System.out.println(mySet+"个数: "+ mySet.getCount());
    }
}
/*
我们只需要重写add()方法就能完成个数的统计,因为addAll底层用的也是add,所以不用再addAll中count++

1.此时代码看起来很完美,已经满足需求

    问题:
    目前这个代码依赖于一个事实,就是HashSet的addAll方法必须去调用add方法
    万一在将来的jdk版本中,HashSet的addAll方法不再调用add方法,那么我们写的这个MySet就出现问题了,失去它的效果了(不在累加添加的元素个数了)
 */
