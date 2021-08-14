package xmlParse.Sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("文档开始解析......");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("元素开始解析......");
        System.out.println("标签名: " + qName);
        if (qName.equals("book")) {
            System.out.println(attributes.getQName(0) + ": " + attributes.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("元素结束解析");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档结束解析");
    }
}
