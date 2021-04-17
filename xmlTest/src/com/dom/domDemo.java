package com.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class domDemo {
    public static void main(String[] args) throws Exception {
        
        //创建Dom解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        //使用解析器工厂创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();


        //使用解析器 解析xml,返回document对象
        File file = new File("./resource/Test.xml");
        Document document = documentBuilder.parse(file);

        NodeList bookNodeList = document.getElementsByTagName("book");

        for (int i = 0; i < bookNodeList.getLength(); i++) {
            Node node = bookNodeList.item(i);

            System.out.println(node.getAttributes().getNamedItem("id"));
            String nodeTextContent = node.getTextContent();
            //System.out.println(nodeTextContent);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node node1 = childNodes.item(j);
                System.out.print(node1.getNodeName()+":"+node1.getTextContent());
            }
        }

    }
}
