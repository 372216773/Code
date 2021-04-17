class Node{
    public int data;
    public Node next;//结点的引用
    //构建时next值不确定,默认为NUll
    public Node(int data) {
        this.data = data;
    }
}//节点的结构都相同,所以将节点抽象成一个类,模板

public class SeqList{

    public Node head;//标识头节点,
    // head是一个可以指向对象的引用

    //头插法
    public void addFirst(int data){

        Node node = new Node(data);

        node.next=this.head;
        this.head=node;

    }

    public void display(SeqList seqList){

        for (Node cur=seqList.head;cur!=null;cur=cur.next) {
            System.out.print(cur.data+" ");
        }
    }

    public void addLast(int data){
        Node node =new Node(data);
        if(this.head==null){//第一次插入
            this.head=node;
        }
        else {
            Node cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    public boolean checkIndex(int index){
        if(index<0||index>getLength()){
            System.out.println("下标不合法!");
            return false;
        }else
            return true;
    }

    public void addInsert(int index,int data){
        //检查是否合法
        if(!checkIndex(index)){
            return;
        }

        if(index==0){
            addFirst(data);
            return;
        }
        if(index==this.getLength()){
            addLast(data);
            return;
        }
        Node cur=searchPrev(index);//查找index-1的位置
        Node cur1=cur.next;
        Node newnode=new Node(data);
        newnode.next=cur1;
        cur.next=newnode;
    }

    private Node searchPrev(int index) {
        Node cur=this.head;
        for (int i = 0; i < index; i++,cur=cur.next);
            return cur;
    }

    private int getLength() {
        Node cur=this.head;
        int count = 0;
        for (count = 0;cur!=null; count++,cur=cur.next);
        return count;
    }


}