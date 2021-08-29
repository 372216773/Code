package com.wj.designPattern.proxy.proxyPlus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface ICalc {
    int add(int a, int b);

    int sub(int a, int b);

    int mul(int a, int b);

    int div(int a, int b);
}

class CalcImpl implements ICalc {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}

//==============================================
class myHandler implements InvocationHandler {

    private Object obj;

    public myHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "开始" + "参数:" + Arrays.toString(args));
        Object trueObjReturn = method.invoke(obj, args);
        System.out.println(method.getName() + "结果为:"+ trueObjReturn);
        return 0;
    }
}

class MyProxy<interfaces> {
    public Object getProxy(Object target){
        ClassLoader classLoader = proxyPlus.class.getClassLoader();
        //获取目标类所实现的接口
        Class[] interfaces = target.getClass().getInterfaces();
        //1.确定类加载器 2.确定接口类型 3.对传进来的实例对象,进行修改 4.返回一个修改过内容的对象
        interfaces iCalc = (interfaces) Proxy.newProxyInstance(classLoader, interfaces, new myHandler(target));
        return iCalc;
    }
}
public class proxyPlus {

    public static void main(String[] args) {
        CalcImpl calc = new CalcImpl();
        MyProxy<CalcImpl> proxy = new MyProxy<>();
        //将实例对象传进去,对他进行改造,返回的内容就会包括,这个实例对象的内容,和自己添加的内容,对他进行改造
        ICalc proxy1 = (ICalc) proxy.getProxy(calc);
        proxy1.add(1,2);
    }
}