package book;

public class BookList {

    private Book[] books = new Book[10];
    private int usedSize;

    //预先放四本书
    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", "立业",2.5);
        books[1] = new Book("水浒传", "施耐庵", "武侠",2.8);
        books[2] = new Book("红楼梦", "曹雪芹", "治家",2.0);
        books[3] = new Book("西游记", "吴承恩", "探险",2.3);
        this.usedSize = 4;
    }

    //查看一共有几本书
    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    //添加书籍
    public void setBooks(int pos,Book book) {
        this.books[pos]=book;
    }

    //得到书籍
    public Book getBook(int pos) {
        return this.books[pos];
    }
}
