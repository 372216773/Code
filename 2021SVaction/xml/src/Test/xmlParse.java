package Test;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class xmlParse<T> {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder;
    Document document = null;
    List<T> list = new ArrayList<>();
    Person person;

    public List<T> domParse(String pathname) {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(pathname);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }

        NodeList stars = document.getElementsByTagName("star");
        for (int i = 0; i < stars.getLength(); i++) {
            Node node = stars.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element star = (Element) node;
                person = new Person();
                String starAttributeNode = star.getAttribute("id");
                person.setId(Integer.parseInt(starAttributeNode));
                NodeList starChildNodes = star.getChildNodes();
                for (int j = 0; j < starChildNodes.getLength(); j++) {
                    Node node1 = starChildNodes.item(j);
                    if (node1.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node1;
                        String tagName = element.getTagName();
                        Object textContent = element.getTextContent();
                        if (tagName.equals("name")) {
                            person.setName((String) textContent);
                        } else if (tagName.equals("age")) {
                            person.setAge(Integer.parseInt((String) textContent));
                        } else {
                            person.setSex((String) textContent);
                        }
                    }
                }
                list.add((T) person);
            }
        }
        return list;
    }

}
