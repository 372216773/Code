package ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addElement(1);
        myArrayList.addElement(2);
        myArrayList.addElement(3);
        myArrayList.addElement(4);
        myArrayList.addElement(5);
        myArrayList.addElement(5);
        myArrayList.display();
        myArrayList.add(0,0);
        myArrayList.add(0,45);
        myArrayList.add(0,35);
        myArrayList.add(0,25);
        myArrayList.add(0,15);
        myArrayList.display();
        myArrayList.addElement1(21);
        myArrayList.addElement1(22);
        myArrayList.display();
    }
}
