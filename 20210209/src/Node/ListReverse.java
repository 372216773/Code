package Node;

public class ListReverse {

    //逆置链表
    public static Node reverse(Node head) {

        /*
        1.定义了一个cur引用
        2.让cur引用指向head引用现在指向的对象
         */
        Node cur = head;

        //表示curPrev引用和temp引用不指向任何对象
        Node curPrev = null;
        //curPrev一样的效果
        //Node temp = null;

        //cur!=null-->cur还指向对象吗
        //cur==null-->cur不指向对象吗
        //只要cur还指向对象,循环就继续
        while(cur != null) {

            //cur引用目前所指向的对象中的next引用现在是否还指向对象吗
            /*if (cur.next==null) {
                //条件成立,cur为尾结点
                temp = cur;
            }*/

            //让curNext这个引用指向cur引用指向的对象中的next引用所指向的对象
            Node curNext = cur.next;

            //用来改变指向
            //cur引用所指向的对象中的next引用指向curPrev引用指向的对象
            cur.next = curPrev;

            //向前移动
            //curPrev引用指向cur引用所指向的对象
            curPrev = cur;
            //cur引用指向curNext引用所指向的对象
            cur = curNext;

        }

        //return temp;
        return curPrev;

    }

    //输出链表
    public static void display(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

        //构造一个1 2 3 4的链表
        /*
        1.定义了一个head引用
        2.构造了Node对象
        3.让head引用指向该Node对象
         */
        Node head = new Node();
        /*
        修改head引用"指向的对象"中的val属性
         */
        head.val = 1;

        /*
        1.构造了一个对象
        2.让head引用指向的对象中的next引用指向该对象
         */
        head.next = new Node();
        head.next.val = 2;

        head.next.next = new Node();
        head.next.next.val = 3;

        head.next.next.next = new Node();
        head.next.next.next.val = 4;

        //逆置链表
        Node reverseHead = reverse(head);

        display(reverseHead);

    }
}
