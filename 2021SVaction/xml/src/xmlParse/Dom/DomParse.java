package xmlParse.Dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParse {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1.创建Dom解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2.创建Dom解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //3.加载文件
        File file = new File("./BookStore.xml");
        //4.解析文件,获得document对象
        Document document = documentBuilder.parse(file);
        //获取根节点元素:document.getDocumentElement();    out:bookStore

        NodeList bookNodeList = document.getElementsByTagName("book");
        for (int i = 0; i < bookNodeList.getLength(); i++) {
            Node bookNode = bookNodeList.item(i);
            //如果这个结点是元素节点,就进行类型转换
            if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) bookNode;
                //获取元素的标签名
                String bookElementTagName = bookElement.getTagName();
                System.out.print(bookElementTagName + " ");
                //获取属性
                Attr attr = bookElement.getAttributeNode("id");
                System.out.println(attr);

                //获得bookElement的子节点
                NodeList childNodeList = bookElement.getChildNodes();
                for (int j = 0; j < childNodeList.getLength(); j++) {
                    Node node = childNodeList.item(j);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element nodeElement = (Element) node;
                        //获得元素标签名
                        String tagName = nodeElement.getTagName();
                        //获得元素内容
                        String textContent = nodeElement.getTextContent();
                        System.out.println(tagName + ": " + textContent);
                    }
                }
            }
            System.out.println("---------------------");
        }
    }
}
