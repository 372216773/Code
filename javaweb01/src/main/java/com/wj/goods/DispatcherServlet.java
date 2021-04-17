package com.wj.goods;

import com.wj.goods.annotation.*;
import com.wj.goods.controller.GoodsController;
import com.wj.goods.controller.MemberController;
import com.wj.goods.service.GoodsService;
import com.wj.goods.util.Dom4jUtil;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/*
1.接收客户端的请求
2.分发请求
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map handlerMapping = (Map) getServletContext().getAttribute("handlerMapping");
        Map beanFactory = (Map) getServletContext().getAttribute("applicationContext");
        //获得url
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        //获得baseName
        String beanName = split[1] + "Controller";

        //得到url对应的方法
        Method method = (Method) handlerMapping.get(requestURI);

        //得到beanName对应的bean对象
        Object bean = beanFactory.get(beanName);

        //调用Method类代表的方法
        try {
            //调用对应的方法
            method.invoke(bean, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    /*
     全局只有唯一的一个容器来存储指定包下的所有的类名全称
     通过类名全称来创建类对象(Class.forName(类名全称)),通过类对象来创建实例对象(类对象.newInstance)
     */
    /*
    //解析properties配置文件后,得到指定包下的所有类名全称
    public static List<String> allClassNameList = new ArrayList<>();

    //解析注解后,<beanName,Object>存放的是所有已创建好的的对象名以及对应的对象
    public static Map<String, Object> beanFactory = new HashMap<>();

    //解析注解后,<String,Method>存放的是url以及对应的方法
    public static Map<String, Method> handlerMapping = new HashMap<>();*/

/**
 * 解析自定义的xml配置文件,把解析的所有的<name,Object>全部放入一个Map中
 *
 * @return 返回一个Map<name, Object>
 * <p>
 * 负责请求的调度
 * 初始化容器,容器中存放的是我们要进行管理的对象(在application.xml中配置的对象)
 * <p>
 * 扫描指定包下的所有类
 * @param basePackagePath 扫描的路径
 * <p>
 * Spring 1.0 2.0 基于Xml解析
 * 基于Xml解析创建Bean容器(Bean工厂),并且给beanMap中已创建好的对象注入属性
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws DocumentException
 * @throws IllegalAccessException
 * <p>
 * xml解析,属性的注入
 * @param beanMap 对象容器
 * <p>
 * 负责请求的调度
 * 初始化容器,容器中存放的是我们要进行管理的对象(在application.xml中配置的对象)
 * <p>
 * 扫描指定包下的所有类
 * @param basePackagePath 扫描的路径
 * <p>
 * Spring 1.0 2.0 基于Xml解析
 * 基于Xml解析创建Bean容器(Bean工厂),并且给beanMap中已创建好的对象注入属性
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws DocumentException
 * @throws IllegalAccessException
 * <p>
 * xml解析,属性的注入
 * @param beanMap 对象容器
 * <p>
 * 负责请求的调度
 * 初始化容器,容器中存放的是我们要进行管理的对象(在application.xml中配置的对象)
 * <p>
 * 扫描指定包下的所有类
 * @param basePackagePath 扫描的路径
 * <p>
 * Spring 1.0 2.0 基于Xml解析
 * 基于Xml解析创建Bean容器(Bean工厂),并且给beanMap中已创建好的对象注入属性
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws DocumentException
 * @throws IllegalAccessException
 * <p>
 * xml解析,属性的注入
 * @param beanMap 对象容器
 */
    /*public static Map<String, Object> initBeanMap() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //专门存放className和bean对象(实例化的对象)
        Map<String, Object> beanMap = new HashMap<>();

        获得根节点

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(DispatcherServlet.class.getClassLoader().getResourceAsStream("application.xml"));
        //获得根节点名称
        //System.out.println(read.getRootElement().getName());
        //获得根节点 beans
        Element rootElement = document.getRootElement();
        //获得根节点 beans
        Element rootElement = Dom4jUtil.getRootElement("application.xml");
        //获得beans节点下的所有的bean元素-->用来创建对象
        List<Element> elements = rootElement.elements("bean");
        for (Element element : elements) {
            String beanName = element.attributeValue("name");
            String className = element.attributeValue("class");
            //根据类的全路径进行类加载,返回该类的Class对象
            //<?>表示可以指向任意类型
            Class<?> clazz = Class.forName(className);
            //产生这个Class类对象的一个实例，
            //调用该类无参的构造方法，作用等同于new一个对象
            Object o = clazz.newInstance();
            beanMap.put(beanName, o);
        }
        return beanMap;
    }*/

/**
 * 负责请求的调度
 * 初始化容器,容器中存放的是我们要进行管理的对象(在application.xml中配置的对象)
 */
    /*public static void dispatcher() throws IOException, ClassNotFoundException, DocumentException, IllegalAccessException, InstantiationException {

        //baseXml();

        //baseAnnotation();

    }*/

    //类名首字母转小写
    /*public static String toLowerName(Class clazz) {
        //获取类名(为大驼峰形式)
        String name = clazz.getSimpleName();
        //化为字符数组进行单个字母的调整
        char[] chars = name.toCharArray();
        //将首个字母小写,改为小驼峰
        chars[0] += 32;
        //赋值给beanName
        return new String(chars);
    }*/


/**
 * 基于注解的解析方式,生成对象的类型还得看注解中的内容
 */
    /*
    private static void baseAnnotation() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //新建资源对象
        Properties properties = new Properties();
        //将资源文件加载进来
        properties.load(DispatcherServlet.class.getClassLoader().getResourceAsStream("application.properties"));
        //读入需要扫描的包名
        String basePackageName = properties.getProperty("scan-package");
        //将包名转为classPath路径
        String basePackagePath = basePackageName.replaceAll("\\.", "/");
        //扫描指定包下的所有类
        doScan(basePackagePath);

        //判断刚才扫描出来的类是否加了@Component/@Controller/@Service/@Repository这些注解
        for (String className : allClassNameList) {
            //获取类对象:Class.forName("类名的全称");
            Class<?> clazz = Class.forName(className);
            //判断这个对象的注解的类型
            //clazz.isAnnotationPresent():给定类型的注释是否存在于此实体上
            if (clazz.isAnnotationPresent(Component.class)) {
                //从注解中获取beanName,只是名称
                String beanName = clazz.getAnnotation(Component.class).value();
                //产生这个Class类对象的一个实例，
                //调用该类无参的构造方法，作用等同于new一个对象
                Object o = clazz.newInstance();
                //如果注解未赋值,即默认值""-->空字符串,则beanName就以类名的小驼峰形式进行命名
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                beanFactory.put(beanName, o);
            }
            一共两种获取到beanName的方式
            1.直接通过注解的值获取
            2.若注解中未赋值,则使用类名的小驼峰形式

            if (clazz.isAnnotationPresent(Controller.class)) {
                String beanName = clazz.getAnnotation(Controller.class).value();
                Object o = clazz.newInstance();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                beanFactory.put(beanName, o);
            }
            if (clazz.isAnnotationPresent(Service.class)) {
                String beanName = clazz.getAnnotation(Service.class).value();
                Object o = clazz.newInstance();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                beanFactory.put(beanName, o);
            }
            if (clazz.isAnnotationPresent(Repository.class)) {
                String beanName = clazz.getAnnotation(Repository.class).value();
                Object o = clazz.newInstance();
                if (beanName.equals("")) {
                    beanName = toLowerName(clazz);
                }
                beanFactory.put(beanName, o);
            }
        }

        //依赖注入(对于beanFactory里的对象的赋值过程),beanName-->对象名称,obj-->对象
        beanFactory.forEach((beanName, obj) -> {
            //获得类对象
            //Class<?> objClass = obj.getClass();
            //获得本类所有属性
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);//强吻
                try {
                    //普通String属性的赋值
                    if (declaredField.isAnnotationPresent(StringValue.class)) {
                        //获取属性上注解的值
                        String value = declaredField.getAnnotation(StringValue.class).value();
                        //为属性赋值set(对象,值)
                        declaredField.set(obj, value);
                    }
                    if (declaredField.isAnnotationPresent(Qualifier.class)) {
                        //获取属性上注解的值
                        String beanName1 = declaredField.getAnnotation(Qualifier.class).beanName();
                        //从beanFactory中获取与注解值相对应的对象
                        Object o = beanFactory.get(beanName1);
                        declaredField.set(obj, o);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        //解析包含@Controller注解的类 的方法,找哪些方法上有@RequestMapping注解
        beanFactory.forEach((beanName, obj) -> {
            if (obj.getClass().isAnnotationPresent(Controller.class)) {
                //解析类对象上有无@RequestMapping注解
                if (obj.getClass().isAnnotationPresent(RequestMapping.class)) {
                    String baseUrl = obj.getClass().getAnnotation(RequestMapping.class).value();
                    //解析方法上有无@RequestMapping注解
                    Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                    for (Method declaredMethod : declaredMethods) {

                        if (declaredMethod.isAnnotationPresent(RequestMapping.class)) {
                            String url = declaredMethod.getAnnotation(RequestMapping.class).value();
                            String allUrl = (baseUrl + url).trim().replaceAll("//", "/");
                            handlerMapping.put(allUrl, declaredMethod);
                        }
                    }
                }
            }
        });
    }

    */
/**
 * 扫描指定包下的所有类
 *
 * @param basePackagePath 扫描的路径
 */
    /*
    public static void doScan(String basePackagePath) {

        //获取classPath路径在硬盘中的url(路径),只能识别相对路径
        URL url = DispatcherServlet.class.getClassLoader().getResource(basePackagePath);

        //从url中获取文件对象(绝对路径)
        //url.getFile()-->D:\wj\javaCode\javaWeb01\target\classes\com\wj\goods
        //String.valueOf(url)-->file:\D:\wj\javaCode\javaWeb01\target\classes\com\wj\goods
        File basePackageFile = new File(url.getFile());
        for (File file : basePackageFile.listFiles()) {
            //isDirectory()是检查一个对象是否是文件夹
            if (file.isDirectory()) {
                doScan(basePackagePath + "/" + file.getName());
            } else {
                //加入类的全称(不包含".class"这个字符串)
                allClassNameList.add(basePackagePath.replaceAll("/", ".") + "." + file.getName().replace(".class", ""));
            }
        }
    }

    */

/**
 * Spring 1.0 2.0 基于Xml解析
 * 基于Xml解析创建Bean容器(Bean工厂),并且给beanMap中已创建好的对象注入属性
 *
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws DocumentException
 * @throws IllegalAccessException
 */
/*
    private static void baseXml() throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        //1.解析xml,得到一个存放className和Object对象的Map<beanName,Object>的容器
        Map<String, Object> beanMap = initBeanMap();
        //2.给我们容器中的对象注入属性
        diProp(beanMap);
        //System.out.println(beanMap);

    }
*/

/**
 * xml解析,属性的注入
 *
 * @param beanMap 对象容器
 */
    /*private static void diProp(Map<String, Object> beanMap) throws DocumentException {

        //拿到根节点 beans
        Element rootElement = Dom4jUtil.getRootElement("application.xml");

        //遍历beanMap
        beanMap.forEach((beanName, obj) -> {
            //获得class对象
            //返回引用obj运行时真正所指的对象所属的类的Class的对象
            Class clazz = obj.getClass();
            //获取本类中定义的所有属性(公有和私有)
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                //获取对象中属性名称
                String declaredFieldName = declaredField.getName();
                //解析xml中配置的属性
                //beans中的bean元素
                List<Element> beanNodes = rootElement.elements("bean");
                for (Element beanNode : beanNodes) {

                    //bean元素中的properties元素
                    Element propertiesElement = beanNode.element("properties");
                    //如果bean元素中含有properties元素,即含有要为对象赋的值
                    if (propertiesElement != null) {

                        //property元素
                        List<Element> propertyNodeList = propertiesElement.elements("property");
                        for (Element propertyNode : propertyNodeList) {

                            //获取xml中的property标签中的name属性的值
                            String name = propertyNode.attributeValue("name");
                            //名称对应
                            if (declaredFieldName.equals(name)) {

                                try {
                                    declaredField.setAccessible(true);//强吻
                                    //如果是数值类型
                                    if (propertyNode.attribute("value") != null) {
                                        //获取xml中的property标签中的value属性的值
                                        String value = propertyNode.attributeValue("value");
                                        //给属性赋值
                                        declaredField.set(obj, value);
                                    }

                                    //如果是引用类型
                                    if (propertyNode.attribute("bean") != null) {
                                        //得到的是字符串
                                        //String bean = propertyNode.attributeValue("bean");

                                        //获取xml中的property标签中的bean引用的值
                                        Object bean = beanMap.get(propertyNode.attributeValue("bean"));
                                        //给属性赋值
                                        declaredField.set(obj, bean);
                                    }
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                    }

                }


            }
        });

    }*/

