package com.wj.Demo1;

import java.util.HashSet;

public class Test1 extends demo5{

    public static void main(String[] args) {
        demo5 d = new demo5();
        d.setUserId(1);
        d.setUserName("张三");
        d.setUserPwd("a111");
        demo5 d1 = new demo5();
        d1.setUserId(2);
        d1.setUserName("李四");
        d1.setUserPwd("a111");
        demo5 d2 = new demo5();
        d2.setUserId(3);
        d2.setUserName("王五");
        d2.setUserPwd("a111");
        HashSet<demo5> hashSet = new HashSet<>();//HashSet是一个集合类
        //使用泛型,使hashSet的类型为demo5
        hashSet.add(d);
        hashSet.add(d1);
        hashSet.add(d2);
        for (demo5 s:hashSet){
            System.out.println(s);
        }
    }

}
