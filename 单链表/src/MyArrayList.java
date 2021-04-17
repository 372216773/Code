import java.util.Arrays;

/* @Title 创建的MyArrayList相当于一个新类型
 *这个类型的数据内有一个数组,有数据个数
 * 可以通过创建对象来设置数组的大小
 * 初始情况下,数组大小为0,数据个数为0
 * @Description ---------------顺序表------------------
 * @Param
 * @return
 * @Author WJ
 * @Date 17:00 2021/1/3
*/
public class MyArrayList {
    public int[] elem;//null
    public int usedSize;//0

    public MyArrayList(int num) {
        this.elem=new int[num];
        this.usedSize=0;
    }

    //打印顺序表
    public void display() {
        System.out.print("[");
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(" "+this.elem[i]);
            if (i<this.usedSize-1) {
                System.out.print(",");
            }else {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    /**在pos位置新增元素,不能空位置
     * 要判断pos位置是否合法
     * @param pos
     * @param data
     */
    public void add(int pos,int data) {
        if (pos<0||pos>this.usedSize) {
            System.out.println("该位置不合法!");
            return;
        }
        if (this.usedSize==this.elem.length) {//扩容,扩为原来的两倍
            this.elem= Arrays.copyOf(this.elem,elem.length*2);
        }
            for (int i = this.usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize++;
    }

    //判断是否含有某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i]==toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i]==toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if (pos<0||pos>this.usedSize) {
            System.out.println("该位置不合法!");
            return-1;
        }
        return this.elem[pos];
    }

    //给pos位置的元素设为value
    public void setPos(int pos,int value) {
        if (pos<0||pos>this.usedSize) {
            System.out.println("该位置不合法!");
            return;
        }
        this.elem[pos]=value;
    }

    //获取顺序表的长度
    public int size() {
        return this.usedSize;
    }

    /* @Title
     * @Description 删除第一次出现的关键字key
    当删除的数据元素为引用类型时,elem[i]=null,防止内存泄漏
    * i的截止位置是 i = this.usedSize-2,this.usedSize-1位置是最后一个值,
    * 不用管,当再加进来数据时会覆盖这个值
     * @Param
     * @return
     * @Author WJ
     * @Date 18:23 2021/1/3
    */
    public void remove(int toMove) {
        if (this.contains(toMove)) {
            for (int i = this.search(toMove); i < this.usedSize-1; i++) {
                this.elem[i]=this.elem[i+1];
            }
        }else {
            System.out.println("没有该数字");
            return;
        }
        this.usedSize--;
    }
}
