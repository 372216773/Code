package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/* @Title
 * @Description 新增图书
 * @Param
 * @return
 * @Author WJ
 * @Date 19:43 2021/1/7
*/
public class AddOperation implements IOperation{
    //所有的操作都是对顺序表进行的操作,就要将这个顺序表传进来进行操作
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("新增图书操作");
        //只需要尾插
        System.out.println("请输入图书名称:");
        String name=scanner.next();
        System.out.println("请输入图书作者:");
        String author=scanner.next();
        System.out.println("请输入图书价格:");
        double price=scanner.nextDouble();
        System.out.println("请输入图书的类型:");
        String type=scanner.next();
        //新添加一本图书,输入图书的位置,图书的信息
        bookList.setBooks(bookList.getUsedSize(),new Book(name,author,type,price));
        bookList.setUsedSize(bookList.getUsedSize()+1);
        System.out.println("添加成功!");
    }
}
