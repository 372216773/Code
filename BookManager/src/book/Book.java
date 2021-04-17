package book;

public class Book {

    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isBorrowed;//默认值为false

    public Book(String name, String author, String type, double price) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book:" + "\n" +
                "|name=      《" + name + "》" + "\n" +
                "|author=    '" + author + '\''  + "\n" +
                "|price=      " + price  + "￥\n" +
                "|isBorrowed= " + isBorrowed  + "\n";
    }

}
