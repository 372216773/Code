package xmlParse.Sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParse {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.创建sax解析器工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2.创建sax解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //文件
        File file = new File("./BookStore.xml");
        saxParser.parse(file,new SaxHandler());
    }
}
