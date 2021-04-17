package com.wj.goods.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//单例
public class Dom4jUtil {

    /*
    定义一个SAXReader类型的引用,为null
     private static SAXReader saxReader
     */
    public static SAXReader saxReader = new SAXReader();

    private Dom4jUtil() {

    }

    /**
     * 获取根节点
     * @param classPathFileName xml文件
     * @return
     * @throws DocumentException
     */
    public static Element getRootElement(String classPathFileName) throws DocumentException {
        Document document = saxReader.read(Dom4jUtil.class.getClassLoader().getResourceAsStream(classPathFileName));
        return document.getRootElement();


    }

}
