package operation;

import book.BookList;

import java.util.Scanner;

/* @Title
 * @Description 查找图书
 * @Param
 * @return
 * @Author WJ
 * @Date 19:46 2021/1/7
*/
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("查找书籍");
        System.out.println("请输入查找图书的名称:");
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println("已找到这本书!");
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("未找到此书籍!");
    }
}
