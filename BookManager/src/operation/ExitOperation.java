package operation;

import book.BookList;

/* @Title
 * @Description 退出系统
 * @Param
 * @return
 * @Author WJ
 * @Date 19:46 2021/1/7
*/
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("已退出系统!");
        System.exit(0);
    }
}
