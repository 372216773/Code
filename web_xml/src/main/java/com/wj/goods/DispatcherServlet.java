package com.wj.goods;

import com.wj.goods.controller.GoodsController;
import com.wj.goods.controller.MemberController;
import com.wj.goods.util.Dom4jUtil;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    1.接收客户端的请求
    2.分发请求
 */
public class DispatcherServlet {



    @Test
    public void dispatcher() throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        baseXml();
    }
    /**基于xml解析创建bean容器(bean工厂),并且注入属性
     *
     */
    public void baseXml() throws DocumentException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        //1.解析xml文件,得到一个存放className和和Object的Map<beanName,Object>的容器
        Map<String, Object> beanMap = initBeanMap();
        //2.给属性注入值
        diProp(beanMap);
        MemberController memberController = (MemberController) beanMap.get("memberController");
        memberController.add();
        GoodsController goodsController = (GoodsController) beanMap.get("goodsController");
        goodsController.remove();
    }

    /**
     * 通过反射给对象属性赋值,就要解析xml文件中的属性中的bean,value值
     *
     * @param beanMap 包含所有的对象
     */
    private void diProp(Map<String, Object> beanMap) throws DocumentException {
        Element rootElement = Dom4jUtil.getRootElement("application.xml");

        beanMap.forEach((beanName, obj) -> {
            //获得类对象
            //返回引用obj运行时真正所指的对象所属的类的Class的对象
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();

                //获取bean标签
                List<Element> beanNodes = rootElement.elements("bean");
                for (Element beanNode : beanNodes) {
                    Element properties = beanNode.element("properties");
                    //有的对象中并没有属性,不加以判断就会出现空指针异常
                    if (properties != null) {
                        List<Element> propertyNodeList = properties.elements("property");
                        for (Element property : propertyNodeList) {
                            String name = property.attributeValue("name");
                            if (name.equals(fieldName)) {
                                field.setAccessible(true);
                                try {
                                    if (property.attribute("value") != null) {
                                        String value = property.attributeValue("value");
                                        field.set(obj, value);
                                    }
                                    if (property.attribute("bean") != null) {
                                        String fieldBeanName = property.attributeValue("bean");
                                        Object bean = beanMap.get(fieldBeanName);
                                        field.set(obj, bean);
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
    }

    /**
     * 解析自定义xml文件,把解析的所有的<name,Object>全部放入Map当中
     *
     * @return 返回一个map中
     */
    public Map<String, Object> initBeanMap() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> classNameMap = new HashMap<>();

        //最外层的标签 beans
        Element rootElement = Dom4jUtil.getRootElement("application.xml");
        //获取标签名为bean的标签
        List<Element> beanElementsList = rootElement.elements("bean");
        for (Element beanElement : beanElementsList) {

            //attribute();//获取属性
            //attributeValue();//获取属性值
            //对象名
            String beanName = beanElement.attributeValue("name");
            //对象
            String className = beanElement.attributeValue("class");
            //根据类的全路径进行类加载,返回该类的Class对象
            //<?>表示可以指向任意类型
            Class<?> clazz = Class.forName(className);
            //产生这个Class类对象的一个实例，
            //调用该类无参的构造方法，作用等同于new一个对象
            Object obj = clazz.newInstance();
            if (beanElement.attribute("factory-method")!=null) {
                String methodName = beanElement.attributeValue("factory-method");
                Method method = clazz.getDeclaredMethod(methodName);
                //调用静态方法
                Class<?> type = method.getReturnType();
                obj = method.invoke(null, (Object) null);
            }
            classNameMap.put(beanName, obj);
        }
        return classNameMap;
    }
}
