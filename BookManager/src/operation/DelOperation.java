package operation;

import book.BookList;

import java.util.Scanner;

/* @Title
 * @Description 删除图书
 * @Param
 * @return
 * @Author WJ
 * @Date 19:44 2021/1/7
*/
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("删除图书");
        System.out.println("请输入要删除的图书:");
        String name=scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {

            if (bookList.getBook(i).getName().equals(name)) {
                for (int j = i; j < bookList.getUsedSize()-1; j++) {
                    //在j位置加入j+1位置上的图书
                    bookList.setBooks(j,bookList.getBook(j+1));
                }
                bookList.setUsedSize(bookList.getUsedSize()-1);
                System.out.println("删除成功!");
                return;
            }
        }
            System.out.println("未找到此图书!");
            System.out.println("删除失败!");
    }
}
