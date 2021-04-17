package com.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;

public class SaxHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        //System.out.println("文档开始解析");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //System.out.println("内容解析");
        String str = String.valueOf(ch,start,length);
        System.out.println(str);
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("文档解析结束.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("元素开始解析"+qName);
        if (qName.equals("book")) {
            System.out.println(attributes.getValue("id"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("元素解析结束"+qName);
    }
}
