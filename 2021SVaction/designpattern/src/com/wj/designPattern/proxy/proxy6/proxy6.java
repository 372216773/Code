package com.wj.designPattern.proxy.proxy6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

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
        interceptor.before(method, args);
        //调用真实方法
        Object trueObjReturn = method.invoke(obj, args);
        interceptor.after(method, trueObjReturn);
        /*
        后置通知,但是写死了
        System.out.println(method.getName() + "结果为:"+ trueObjReturn);
         */
        //应该由用户决定
        return 0;
    }
}

interface Interceptor {
    //获得invoke中的method,args参数
    void before(Method method, Object[] args);

    //获得invoke中调用的真实对象的返回值
    void after(Method method, Object trueObjReturn);
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
        return Proxy.newProxyInstance(classLoader, interfaces, new myHandler(target, interceptor));
    }
}

//===============================================================================================

//所有请求都拦,但是只会给指定方法加日志
class AddInterceptor implements Interceptor {

    @Override
    public void before(Method method, Object[] args) {
        //如果是add方法就加中文日志
        if (method.getName().equals("add")) {
            System.out.println(method.getName() + "AAAAAAAAAAAAAAAAAAAA");
        }
    }

    @Override
    public void after(Method method, Object trueObjReturn) {
        //如果是add方法就加中文日志
        if (method.getName().equals("add")) {
            System.out.println(method.getName() + "AAAAAAAAAAAAAAAAAAAA");
        }
        //其他方法不加通知
    }
}

//所有请求都拦,但是只会给指定方法加日志
class SubInterceptor implements Interceptor {

    @Override
    public void before(Method method, Object[] args) {
        System.out.println(method.getName() + "BBBBBBBBBBBBBBBB");
    }

    @Override
    public void after(Method method, Object trueObjReturn) {
        System.out.println(method.getName() + "BBBBBBBBBBBBBBBB");
    }
}

public class proxy6 {

    public static void main(String[] args) {
        ICalc calc = new CalcImpl();

        ArrayList<Interceptor> list = new ArrayList<>();
        //添加拦截器
        list.add(new AddInterceptor());
        list.add(new SubInterceptor());
        /*要按照用户设置的顺序来带调用,就必须逆向传输*/
        for (int i = list.size() - 1; i >= 0; i--) {
            //从list中拿到拦截器
            Interceptor interceptor = list.get(i);
            //对于calc对象进行指定拦截器的拦截
            calc = (ICalc) MyProxy.getProxy(calc, interceptor);
        }
        calc.add(1, 2);

    }
}
/*
    对添加拦截器的操作进行封装,用properties文件配置需要添加的拦截器,springMVC底层原理
 */