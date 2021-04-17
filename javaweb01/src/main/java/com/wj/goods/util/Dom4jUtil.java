package com.wj.goods.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jUtil {

    public  static SAXReader saxReader = new SAXReader();

    private Dom4jUtil() {}

    /*static{

    }*/

    /**
     * 获得根节点
     * @param classPathFileName
     * @return
     * @throws DocumentException
     */
    public static Element getRootElement(String classPathFileName) throws DocumentException {

        //路径的设置
        Document document = saxReader.read(Dom4jUtil.class.getClassLoader().getResourceAsStream(classPathFileName));
        return document.getRootElement();

    }

}
