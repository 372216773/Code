public class Gc {
    public Gc(){
        System.out.println("gc 构造器");
    }
    public void finalize(){
        System.out.println("垃圾回收调用finalize()方法");
    }
}
