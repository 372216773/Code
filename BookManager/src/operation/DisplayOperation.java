package operation;

import book.BookList;

/* @Title
 * @Description 显示所有图书
 * @Param
 * @return
 * @Author WJ
 * @Date 19:46 2021/1/7
*/
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有书籍");

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
