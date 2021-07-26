package Comparable;

import java.util.Arrays;

class Book implements Comparable<Book> {
    int number;
    String name;
    int price;

    public Book(int number, String name, int price) {
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

    @Override
    public int compareTo(Book o) {
        return this.number - o.number;
    }

}

public class Interface1 {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book(2, "book1", 1);
        books[1] = new Book(1, "book2", 2);
        books[2] = new Book(3, "book3", 3);

        System.out.println(Arrays.toString(books));
        //排序
        Arrays.sort(books);

        System.out.println(Arrays.toString(books));
    }
}
