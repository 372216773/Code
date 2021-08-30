package com.wj.designPattern.proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        System.out.println("要被添加日志的方法");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("要被添加日志的方法");
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("要被添加日志的方法");
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("要被添加日志的方法");
        return a / b;
    }
}

class myHandler implements InvocationHandler {

    private Object obj;
    private Interceptor interceptor;

    public myHandler(Object obj, Interceptor interceptor) {
        this.obj = obj;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
        前置通知,但是写死了
        System.out.println(method.getName() + "开始" + "参数:" + Arrays.toString(args));
         */
        //应该由用户决定
        interceptor.before();
        //调用真实方法
        Object trueObjReturn = method.invoke(obj, args);
        interceptor.after();
        /*
        后置通知,但是写死了
        System.out.println(method.getName() + "结果为:"+ trueObjReturn);
         */
        //应该由用户决定
        return 0;
    }
}

interface Interceptor {
    void before();
    void after();
}

class MyProxy {

    //封装:对外隐藏复杂的实现,暴露出简单的使用方法
    //静态:就不用再创建这个对象
    //
    public static Object getProxy(Object target, Interceptor interceptor) {
        //获得类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //字节码实现什么的接口,获就取目标类所实现的接口
        Class[] interfaces = target.getClass().getInterfaces();
        //1.确定类加载器 2.确定要实现的接口类型 3.对传进来的实例对象,进行修改 4.返回一个修改过内容的对象
        //用Object为了通用性
        return Proxy.newProxyInstance(classLoader, interfaces, new myHandler(target,interceptor));
    }
}

//===============================================================================================

//用户自己设置日志内容
class A implements Interceptor{

    @Override
    public void before() {
        System.out.println("用户自定义的第一种的前置通知");
    }

    @Override
    public void after() {
        System.out.println("用户自定义的第一种的后置通知");
    }
}

class B implements Interceptor{

    @Override
    public void before() {
        System.out.println("用户自定义的第二种的前置通知");
    }

    @Override
    public void after() {
        System.out.println("用户自定义的第二种的后置通知");
    }
}

public class proxy2 {

    public static void main(String[] args) {
        CalcImpl calc = new CalcImpl();

        //将实例对象传进去,对他进行改造,返回的是Object类型的,会进到invoke()中,
        // 对他进行改造,内容包括这个实例对象的内容和自己添加的内容
        ICalc proxy1 = (ICalc) MyProxy.getProxy(calc,new A());
        proxy1.add(1, 2);

    }
}
/*
    优点:
        将日志从invoke中解耦出来,可以自己设置日志的内容,不再局限于固定的日志
    缺点:
        但是日志不能再去访问方法的有关参数
 */