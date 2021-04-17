public class RealLinkedListTestDemo {
    public static void main(String[] args) {
        RealLinkedList realLinkedList=new RealLinkedList();
        realLinkedList.addFirst(4);
        realLinkedList.addFirst(3);
        realLinkedList.addFirst(2);
        realLinkedList.addFirst(1);
        realLinkedList.addFirst(0);
        realLinkedList.addLast(5);
        realLinkedList.addLast(6);
        realLinkedList.addLast(7);
        realLinkedList.addLast(8);
        realLinkedList.addLast(9);
        realLinkedList.displayNext();
        //realLinkedList.displayPrev();
        realLinkedList.addIndex(0,-1);

        realLinkedList.displayNext();
        realLinkedList.addIndex(3,10);
        realLinkedList.displayNext();
        realLinkedList.addIndex(12,99);
        realLinkedList.addIndex(12,99);
        realLinkedList.addIndex(12,99);
        realLinkedList.displayNext();
        realLinkedList.removeAllKey(99);
        realLinkedList.displayNext();

    }
}
