package com.wj.goods.listener;

import com.wj.goods.DispatcherServlet;
import com.wj.goods.annotation.*;
import com.wj.goods.util.JdbcUtil;
import org.apache.commons.dbutils.handlers.MapListHandler;
import sun.security.krb5.internal.PAData;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.util.*;

public class ContextLoadListener implements ServletContextListener {

    //解析properties配置文件后,得到指定包下的所有类名全称
    public static List<String> allClassNameList = new ArrayList<>();

    //解析注解后,<beanName,Object>存放的是所有已经创建好的对象名和对应的对象
    public static Map<String, Object> beanFactory = new HashMap<>();

    //解析注解后,<String,Method>存放的是url以及相对应的方法
    public static Map<String, Method> handlerMapping = new HashMap<>();

    /**
     * tomcat启动执行
     * 在tomcat启动时初始化容器(给容器赋值)
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            baseAnnotation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        servletContextEvent.getServletContext().setAttribute("allClassNameList", allClassNameList);
        servletContextEvent.getServletContext().setAttribute("applicationContext", beanFactory);
        servletContextEvent.getServletContext().setAttribute("handlerMapping", handlerMapping);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    /**
     * 基于注解的解析方式
     */
    private void baseAnnotation() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        //新建资源对象
        Properties properties = new Properties();
        //将资源对象加载进来
        properties.load(DispatcherServlet.class.getClassLoader().getResourceAsStream("application.properties"));
        //读入需要扫描的包名
        String basePackageName = properties.getProperty("scan-package");
        //需要得到所有类名全称,就要进行包扫描,包扫描则需要路径
        //所以要把得到的包名转换成路径
        String basePackagePath = basePackageName.replaceAll("\\.", "/");
        //1.扫描包
        doScan(basePackagePath);
        //2.判断判断刚才扫描出来的类是否加了@Component/@Controller/@Service/@Repository这些注解
        initBeanFactory();
        //3.依赖注入
        DI();
    }

    /**
     * 通过遍历beanFactory得到类对象,依赖注入(所有类名的全称,所有的对象名以及对应的对象,url以及对应的方法)
     */
    private void DI() {
        beanFactory.forEach((name, bean) -> {
            //获得类对象
            Class<?> clazz = bean.getClass();
            //获得对象全部属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    //对象注入
                    if (field.isAnnotationPresent(Qualifier.class)) {
                        String beanName = field.getAnnotation(Qualifier.class).beanName();
                        if (beanName.equals("")) {
                            Class<?> clazzName = field.getType();
                            beanName = toLowerName(clazzName);
                        }
                        Object o = beanFactory.get(beanName);
                        field.set(bean, o);
                    }
                    //String类型值注入
                    if (field.isAnnotationPresent(StringValue.class)) {
                        String value = field.getAnnotation(StringValue.class).value();
                        field.set(bean, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //对象上是否有Controller注解
            if (clazz.isAnnotationPresent(Controller.class)) {
                //对象上是否有RequestMapping注解
                if (clazz.isAnnotationPresent(RequestMapping.class)) {
                    String baseUrl = clazz.getAnnotation(RequestMapping.class).value();
                    //获得对象中全部方法
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            String url = method.getAnnotation(RequestMapping.class).value();
                            url = url.replaceAll("//|/", "");
                            String allUrl = baseUrl + "/" + url;
                            handlerMapping.put(allUrl, method);
                        }
                    }
                }
            }
        });
    }

    /**
     * 通过allClassNameList创建类对象,解析注释在类上的注解,并加入到beanFactory容器中
     */
    public void initBeanFactory() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (String className : allClassNameList) {
            //className为包名,创建类对象,进行判断是否加有注解
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Controller.class)) {
                String beanName = clazz.getAnnotation(Controller.class).value();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                Object bean = clazz.newInstance();
                beanFactory.put(beanName, bean);
            }
            if (clazz.isAnnotationPresent(Service.class)) {
                String beanName = clazz.getAnnotation(Service.class).value();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                Object bean = clazz.newInstance();
                beanFactory.put(beanName, bean);
            }
            //注释有Response注解的是接口,不能直接实例对象,通过代理的方式生成代理接口的实例
            if (clazz.isAnnotationPresent(Repository.class)) {
                String beanName = clazz.getAnnotation(Repository.class).value();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }                                                                                     //这个参数cnm
                Object bean = Proxy.newProxyInstance(ContextLoadListener.class.getClassLoader(),  new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    //每次调用代理对象的方法，最终都会调用InvocationHandler的invoke()方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent(Query.class)) {
                            //查询操作
                            //拿到sql语句
                            String sql = method.getAnnotation(Query.class).value();
                            //需要执行sql语句,引入queryRunner
                            //返回的类型应与接口中方法定义的类型相同
                            Object[] params = new Object[]{};
                            return JdbcUtil.getQueryRunner().query(sql,params ,new MapListHandler());
                        }
                        if (method.isAnnotationPresent(Update.class)) {
                            //增删改操作
                            String sql = method.getAnnotation(Update.class).value();
                            //args就是参数
                            return JdbcUtil.getQueryRunner().update(sql, args);
                        }
                        return null;
                    }
                });
                beanFactory.put(beanName,bean);
            }
            if (clazz.isAnnotationPresent(Component.class)) {
                String beanName = clazz.getAnnotation(Component.class).value();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                Object bean = clazz.newInstance();
                beanFactory.put(beanName, bean);
            }
        }
    }

    /**
     * 类名首字母小写
     *
     * @param clazz 类对象
     * @return 对象名
     */
    public static String toLowerName(Class<?> clazz) {
        String name = clazz.getSimpleName();
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }

    /**
     * 扫描包,并把所有类名放入allClassNameList
     *
     * @param basePackagePath 用户设置的包名
     */
    private void doScan(String basePackagePath) {
        //获取classPath路径在硬盘中的url(路径),这种方式只能识别先对路径
        URL url = DispatcherServlet.class.getClassLoader().getResource(basePackagePath);
        //File对象代表磁盘中实际存在的文件和目录
        //主要用于文件和目录的创建、文件的查找和文件的删除等
        File basePackageFile = new File(url.getFile());
        File[] files = basePackageFile.listFiles();
        //com.wj是父目录,遍历com.wj下的子目录,只有一个goods目录
        for (File file : files) {
            //判断file对象是否为目录
            if (file.isDirectory()) {
                //得到com.wj.goods相对路径
                doScan(basePackagePath + "/" + file.getName());
            } else {
                allClassNameList.add(basePackagePath.replaceAll("/", "\\.") + "." + file.getName().replace(".class", ""));
            }
        }

    }

}
