package com.wj.goods.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jUtil {
    private static SAXReader saxReader = new SAXReader();
    private Dom4jUtil(){}


    public static Element getRootElements (String classPathFileName) throws DocumentException {
        Document document = saxReader.read(Dom4jUtil.class.getClassLoader().getResourceAsStream(classPathFileName));
        return (Element) document.getRootElement();

    }
}
