package Comparator;

import java.util.Arrays;

class Book3{
    int number;
    String name;
    int price;

    public Book3(int number, String name, int price) {
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

public class Interface3 extends BookComparator{
    public static void main(String[] args) {
        Book3[] books = new Book3[3];
        books[0] = new Book3(2, "b", 1);
        books[1] = new Book3(1, "e", 2);
        books[2] = new Book3(3, "a", 3);

        System.out.println(Arrays.toString(books));
        BookComparator bookComparator = new BookComparator();
        Arrays.sort(books,bookComparator);
        System.out.println(Arrays.toString(books));
    }
}
