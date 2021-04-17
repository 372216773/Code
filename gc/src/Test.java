public class Test {
    public static void main(String[] args) {
        Gc gc=new Gc();
        gc=null;
        System.gc();

    }
}
