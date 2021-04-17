package operation;

import book.BookList;

/*
所有的操作类都会进行work()操作,所以将这个"行为"抽象,就新建一个接口,
实现过程让每个操作类来实现
 */
public interface IOperation {
    //默认为public抽象方法,相较于普通方法只是没有方法体,其他相同
    void work(BookList bookList);
}
