package xmlParse.Dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class dom4jParse {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("./RainBowSea.xml");
        Element rootElement = document.getRootElement();
        List<Element> stars = rootElement.elements("star");
        for (Element star : stars) {
            System.out.println(star.attributeValue("id"));
            System.out.println(star.element("name").getText());
            System.out.println(star.element("age").getText());
            System.out.println(star.element("sex").getText());
            System.out.println("===========================");
        }
    }
}
