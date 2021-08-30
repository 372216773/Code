package com.wj.designPattern.proxy.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理
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

class myHandler implements InvocationHandler {

    private Object obj;

    public myHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "开始" + "参数:" + Arrays.toString(args));
        //调用真实方法
        Object trueObjReturn = method.invoke(obj, args);
        System.out.println(method.getName() + "结果为:"+ trueObjReturn);
        return 0;
    }
}

class MyProxy {

    //封装:对外隐藏复杂的实现,暴露出简单的使用方法
    //静态:就不用再创建这个对象
    //
    public static Object getProxy(Object target){
        //获得类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //字节码实现什么的接口,获就取目标类所实现的接口
        Class[] interfaces = target.getClass().getInterfaces();
        //1.确定类加载器 2.确定要实现的接口类型 3.对传进来的实例对象,进行修改 4.返回一个修改过内容的对象
        //用Object为了通用性
        return Proxy.newProxyInstance(classLoader, interfaces, new myHandler(target));
    }
}

//===============================================================================================

interface Food{
    void eat();
}

class noddles implements Food {

    @Override
    public void eat() {
        System.out.println("吃面条!");
    }
}

public class proxy1 {

    public static void main(String[] args) {
        CalcImpl calc = new CalcImpl();
        //将实例对象传进去,对他进行改造,返回的是Object类型的,会进到invoke()中,
        // 对他进行改造,内容包括这个实例对象的内容和自己添加的内容
        ICalc proxy1 = (ICalc) MyProxy.getProxy(calc);
        proxy1.add(1,2);

        noddles noddles = new noddles();
        Food proxy = (Food) MyProxy.getProxy(noddles);
        proxy.eat();
    }
}
/*
    日志功能单一,只能是在调用真实方法的前后加日志,无法加其他功能
 */