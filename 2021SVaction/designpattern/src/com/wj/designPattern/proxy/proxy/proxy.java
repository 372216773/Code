package com.wj.designPattern.proxy.proxy;

import java.lang.reflect.*;
import java.util.Arrays;

/*
所以就要学习jdk的api:动态代理
 */
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

    private CalcImpl calc;

    //从外边传来的对象
    public myHandler(CalcImpl calc) {
        this.calc = calc;
    }

    /*
        参数对应:   1.对象(没用) 2.方法 3.参数
         */
    //就是一个万用模板
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "开始" + "参数:" + Arrays.toString(args));
        //利用反射机制,调用obj的方法,参数为args(obj就得是真实对象)
        Object trueObjReturn = method.invoke(calc, args);
        System.out.println(method.getName() + "结果为:"+ trueObjReturn);
        //与要实现接口定义的方法的返回类型相同
        return 0;
    }
}

public class proxy {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //通过Proxy类中的静态方法,创建代理对象,通过proxy.class字节码文件getClassLoader()获取加载类的类加载器
        /*
        第一个参数:构造器
        实例化一个对象,就会调用类的构造器,在调用构造器之前,jvm就会通过类加载器自动加载该类的字节码
        但是动态创建对象需要我们手动传入类加载器来加载类的字节码
         */
        ClassLoader classLoader = proxy.class.getClassLoader();
        /*
        第二个参数:字节码数组
        确定类加载器要加载哪个类的字节码,这个字节码是运行时动态生成的字节码,是根据目标接口生成的,这是不需要源代码的,
        字节码的内容就是实现了目标接口的字节码
         */
        Class[] interfaces = {ICalc.class};
        /*
        三个参数:调用处理器,InvocationHandler
        既然要实现目标接口,那么第三个参数就要确定方法体的内容,
        invoke就是方法体的内容,把真实对象加进来,是为了获取真实对象的返回值之类的信息
         */

        /*
        返回的是实现了接口的类,用接口类型接收
         */

        //真实对象,目标对象
        CalcImpl calc = new CalcImpl();

        //代理对象
        ICalc iCalc = (ICalc) Proxy.newProxyInstance(classLoader, interfaces, new myHandler(calc));
        //会进入到invoke()中
        iCalc.add(1, 2);
        iCalc.div(1, 2);
        iCalc.mul(1, 2);
        iCalc.sub(1, 2);


    }
}
/*
    解决了每个方法都要独立设置日志内容,现在只需要改一个地方即可(类似于拦截器,每个方法都会经过拦截器)
    缺点:
    写起来麻烦!,那就把这个代码封装起来,对用户更友好

 */