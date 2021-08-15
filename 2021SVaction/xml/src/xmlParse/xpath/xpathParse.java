package xmlParse.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class xpathParse {
    public static void main(String[] args) throws DocumentException {
        //创建Dom4j的解析器
        SAXReader saxReader = new SAXReader();
        //解析文件
        Document document = saxReader.read("./RainBowSea.xml");
        //获取全部的节点
        List<Element> list = document.selectNodes("/member/star");
        for (Element node : list) {
            System.out.println(node.attribute("id").getName() + ": " + node.attributeValue("id"));
            Element name = node.element("name");
            System.out.println(name.getName() + ": " + name.getText());
            Element age = node.element("age");
            System.out.println(age.getName() + ": " + age.getText());
            Element sex = node.element("sex");
            System.out.println(sex.getName() + ": " + sex.getText());
            System.out.println("===========================");
        }
    }
}
