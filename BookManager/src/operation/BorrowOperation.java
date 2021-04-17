package operation;

import book.BookList;

import java.util.Scanner;

/* @Title
 * @Description 借阅书籍
 * @Param
 * @return
 * @Author WJ
 * @Date 19:43 2021/1/7
*/
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("借阅书籍");
        System.out.println("请输入要借阅的书籍:");
        String name=scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                bookList.getBook(i).setBorrowed(true);
                System.out.println("借阅成功!");
                return;
            }
        }
        System.out.println("未找到此书!");
        System.out.println("借阅失败!");
    }
}
