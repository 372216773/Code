package com.wj.designPattern.proxy.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


//反射机制
public class reflect {
    //1.获取列的字节码,是根据源代码生成的,所以源代码中的信息,字节码中也有
    Class<?> clazz = Class.forName("com.wj.designPattern.proxy.proxy1.Food");

    //2.利用反射机制创建一个对象,以下api就是利用反射机制,调用类的无参构造器来实例化对象
    Object obj = clazz.newInstance();

    //3.反射出字节码中的某个方法,反射的是eat的无参的方法
    Method method = clazz.getDeclaredMethod("eat");

    public reflect() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //4.利用反射调用方法,无参方法
        //把method所代表的方法,当作obj的方法来调用,调用obj的方法就是调用method方法(但受到类型的限制)
        method.invoke(obj);
    }
}
