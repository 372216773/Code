package Test;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        SaxParse saxParse = new SaxParse();
        List<Person> list = saxParse.parse("./RainbowSea.xml");
        for (Person person: list) {
            System.out.println(person);
        }
    }
}
