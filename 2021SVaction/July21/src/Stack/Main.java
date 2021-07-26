package Stack;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("size: " + stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.elem[i] + " ");
        }
        System.out.println();
        System.out.println("size: " + stack.size());
        System.out.println("topElem: " + stack.peek());
        stack.pop();
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.elem[i] + " ");
        }

        System.out.println("size: " + stack.size());
    }
}
