package clone;

import java.util.Arrays;

class Book1 {
    int number;
    String name;
    int price;

    public Book1() {}

    public Book1(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Interface2 {

    public static void main(String[] args) {
        Book1[] Books = new Book1[3];
        Books[0] = new Book1(1,"a",2);
        Books[1] = new Book1(2,"b",3);
        Books[2] = new Book1(3,"c",4);
        System.out.println(Arrays.toString(Books));
        Book1[] Books1 = Books.clone();
        System.out.println(Arrays.toString(Books1));
    }
}
