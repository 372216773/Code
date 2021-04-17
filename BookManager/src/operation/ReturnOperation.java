package operation;

import book.BookList;

import java.util.Scanner;

/* @Title
 * @Description 归还图书
 * @Param
 * @return
 * @Author WJ
 * @Date 19:46 2021/1/7
*/
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("归还书籍");
        System.out.println("请输入要归还的书籍:");
        String name=scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                bookList.getBook(i).setBorrowed(false);
                System.out.println("归还成功!");
                return;
            }
        }
        System.out.println("归还失败");
    }
}
