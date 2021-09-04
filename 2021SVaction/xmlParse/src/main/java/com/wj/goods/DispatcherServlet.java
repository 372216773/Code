package com.wj.goods;

import com.wj.goods.controller.GoodsController;
import com.wj.goods.controller.MemberController;
import com.wj.goods.util.Dom4jUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
分发调度器
作用:
    1.接收客户端的请求
    2.分发请求
 */
@WebServlet(urlPatterns = "/")
public class DispatcherServlet {

    /**
     * 解析xml文件,把解析的所有className全部放入一个Map<beanName,Bean>中
     *
     * @return Map<beanName, Bean>
     * @throws DocumentException
     */
    private Map<String, Object> initBeanMap() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Map<String, Object> beanMap = new HashMap<>();

        //获得根节点
        Element rootElement = Dom4jUtil.getRootElements("application.xml");
        //获取bean元素
        List<Element> beanElements = rootElement.elements("bean");
        for (Element bean : beanElements) {
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            //
            Class aClass = Class.forName(className);
            Object object = aClass.newInstance();
            beanMap.put(name, object);
        }
        return beanMap;
    }

    /**
     * 负责请求的调度
     */
    @Test
    public void dispatcher() throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        //1.解析xml文件,得到存放className的Map<beanName,Bean>的容器(IOC)
        // 并把得到的className通过反射来实例化成单例对象
        Map<String, Object> beanMap = initBeanMap();
        //2.给对象容器中注入属性(依赖注入)
        diProp(beanMap);
        MemberController memberController = (MemberController) beanMap.get("memberController");
        memberController.add();

        GoodsController goodsController = (GoodsController) beanMap.get("goodsController");
        goodsController.remove();
    }

    /**
     * 属性注入
     *
     * @param beanMap 对象容器
     */
    public void diProp(Map<String, Object> beanMap) throws DocumentException {
        Element rootElements = Dom4jUtil.getRootElements("application.xml");
        beanMap.forEach((beanName, obj) -> {
            //获取到本类中全部的属性(包括私有属性)
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                String fieldName = field.getName();
                //解析xml中配置的信息
                List<Element> beanList = rootElements.elements("bean");
                for (Element beanNode : beanList) {
                    Element propertiesNode = beanNode.element("properties");
                    if (propertiesNode != null) {
                        List<Element> propertyList = propertiesNode.elements("property");
                        for (Element property : propertyList) {
                            //获取xml中配置的name属性
                            String nameValue = property.attributeValue("name");
                            if (fieldName.equals(nameValue)) {
                                try {
                                    //强吻
                                    field.setAccessible(true);
                                    //value
                                    if (property.attributeValue("value") != null) {
                                        String value = property.attributeValue("value");
                                        field.set(obj, value);
                                    }
                                    //bean
                                    if (property.attributeValue("bean") != null) {
                                        String beanValue = property.attributeValue("bean");
                                        Object bean = beanMap.get(beanValue);
                                        field.set(obj,bean);
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
}
