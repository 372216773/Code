public class Test {
    public static void main(String[] args) {
        SeqList seqList=new SeqList();
        seqList.addFirst(1);
        seqList.addFirst(2);
        seqList.addFirst(3);
        seqList.addFirst(4);
        seqList.addLast(0);
        seqList.addLast(-1);
        seqList.addLast(-2);
        seqList.addLast(-3);
        seqList.addLast(-4);
        seqList.addInsert(3,44);

        seqList.display(seqList);
    }
}
