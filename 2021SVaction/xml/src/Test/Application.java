package Test;

import org.dom4j.DocumentException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws DocumentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        xmlParse saxParse = new xmlParse();
        List<Person> list = saxParse.domParse("./RainbowSea.xml");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}