package com.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class saxDemo {

    public static void main(String[] args) throws Exception {

        //创建sax解析器工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        //使用解析器工厂创建解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();

        //
        File file = new File("./resource/Test.xml");
        saxParser.parse(file,new SaxHandler());



    }
}

