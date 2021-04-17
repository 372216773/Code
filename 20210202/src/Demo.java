import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {

        //创建dom4j对象
        SAXReader saxReader = new SAXReader();

        //解析文件
        Document document = saxReader.read("./resource/Test.xml");

        //获得根节点
        //一级一级的拿到,跨级是拿不到的
        Element rootElement = document.getRootElement();

        //获得所有的book元素
        List<Element> bookElements = rootElement.elements("book");

        for (Element element: bookElements) {

            //getQName:获取元素的
            //1.来历：qname是qualified name 的简写
            //2.构成：由名字空间(namespace)前缀(prefix)以及冒号(:),还有一个元素名称构成.就是一个qname
            //System.out.println(element.getQName());
            System.out.println(element.getName());
            System.out.println(element.attribute("id").getName() + "=" + element.attributeValue("id"));
            System.out.println(element.element("name").getName() + "=" + element.element("name").getText());
            System.out.println(element.element("author").getName() + "=" + element.element("author").getText());
            System.out.println(element.element("price").getName() + "=" + element.element("price").getText());
            System.out.println("--------------------------------------------------");
        }




        //xpath
        //获得根节点
        List<Element> list = document.selectNodes("/bookstore/book/name");
        for (Element element1: list) {
            System.out.println(element1.getText());
            System.out.println("==============================");
        }
    }
}
