package Comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book3> {

    //
    @Override
    public int compare(Book3 o1, Book3 o2) {
        return o1.number - o2.number;
    }
}
