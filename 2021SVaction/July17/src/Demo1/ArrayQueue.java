package Demo1;

import java.util.Scanner;

public class ArrayQueue {

    public static void main(String[] args) {

        //创建队列
        Queue queue = new Queue(8);

        Scanner scanner = new Scanner(System.in);

        char key;
        boolean loop = true;
        int value;
        int res;
        //菜单
        while(loop) {
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列中取出数据");
            System.out.println("s(show) 显示队列中的所有数据");
            System.out.println("h(head) 显示队列头的数据");
            System.out.println("e(exit) 退出");
            //获取到用户输入的字符
            key = scanner.next().charAt(0);
            switch(key) {
                case 'a':
                    System.out.println("请输入你要添加的数据:\n");
                    value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    res = queue.getQueue();
                    System.out.println("从队列中取出的值为: " + res);
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    try{
                        res = queue.headQueue();
                        System.out.println("该队列头数据为: " + res);
                    } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出");
                    break;
            }
        }

    }
}


//数组是一次性,存在问题
//使用数组模拟队列
class Queue{
    private int maxSize;    //队列最大容量
    private int front;      //表示队列头的前一个位置
    private int rear;       //表示队列尾
    private int[] array;    //存放数据,模拟队列

    //队列的构造器
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = -1;         //指向队列的前一个位置
        this.rear = -1;          //指向队列尾的位置
    }

    //判断队列是否满
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    //添加数据到队列
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满,无法加入该值");
            return;
        }
        this.array[++this.rear] = data;
    }

    //从队列中取出数据(先进先出)
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取出数据");
        }
        return this.array[++this.front];
    }

    //显示队列中的所有数据
    public void showQueue() {
        for (int i = this.front +1; i < this.array.length; i++) {
            System.out.printf("array[%d] = %d\n",i,this.array[i]);
        }
    }

    //显示队列头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法显示独立额头元素");
        }
        return this.array[this.front + 1];
    }


}