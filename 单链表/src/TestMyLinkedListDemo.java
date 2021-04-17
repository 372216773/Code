/* @Title
 * @Description 单链表测试类
 * @Param
 * @return
 * @Author WJ
 * @Date 19:55 2021/1/3
*/
public class TestMyLinkedListDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addLast(7);

        myLinkedList.display();
        myLinkedList.reverseList();
        myLinkedList.display();
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addLast(0);
        myLinkedList1.addLast(10);
        myLinkedList1.addLast(20);
        myLinkedList1.addLast(30);
        myLinkedList1.addLast(40);
        myLinkedList1.addLast(50);
        myLinkedList1.addLast(60);
        myLinkedList1.addLast(70);


        //MyLinkedList.createCut(myLinkedList.head,myLinkedList1.head);

        //System.out.println(MyLinkedList.getIntersectionNodePlus(myLinkedList.head,myLinkedList1.head).data);

        //MyLinkedList.displayWithHeadNode(MyLinkedList.mergeTwoLists(myLinkedList.head, myLinkedList1.head));

    }
}
