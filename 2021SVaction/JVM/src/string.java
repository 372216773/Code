
public class string {
    /*
    常量池中的信息,都会被加载到运行时常量池中,这是a,b,ab都是常量池中的符号,还没有变成java字符串对象
    ldc #2 会把a符号变为"a"字符串对象(当(用到)包含这个符号的方法(指令)进入到操作栈和局部变量表中,这个对象才会被创建)
    ldc #3 会把a符号变为"b"字符串对象
    ldc #4 会把a符号变为"ab"字符串对象
     */
    /*
    如果没有"a",就把生成的"a"放到里边,不同的取值只会存在一份
    StringTable(字符串常量池hashtable结构,不能扩容):    ["a","b","ab"]
     */
    public static void main(String[] args) {
        /*String s1 = "a";
        String s2 = "b";
        String s5 = "ab";
        String s4 = s1 + s2;*/
        /*
        1.调用StringBuilder的无参构造方法,创建了一个StringBuilder的对象 new StringBuilder();
        2.从局部变量表中拿到s1再调用StringBuilder的append()方法 new StringBuilder().append("a");
        3.从局部变量表中拿到s2再调用StringBuilder的append()方法 new StringBuilder().append("a").append("b");
        4.调用toString()方法 new StringBuilder().append("a").append("b").toString();
        StringBuilder的toString()方法会new一个新的对象返回回来,存在堆中
        将toString()得到的结果,存到局部变量表中的4号局部变量,并不在常量池中
        */

        //String s3 = "a" + "b";
        /*
        javac在编译期的优化,结果在编译期就已经可以确定
         */

        /*String s6 = s4.intern();
        System.out.println(s3 == s4);
        //不相等,s3会被编译器优化,即s3="ab",s4=s1+s2,因为是变量,底层就调用StringBuilder,产生新的对象,这个对象指向常量池中的"ab"
        System.out.println(s3 == s5);
        //s3会被编译器优化,即s3="ab",指向"ab",s5也指向"ab",所以想等
        System.out.println(s3 == s6);
        //s4手动入池,指向常量池中的"ab",即s6指向常量池中的"ab",所以相等
*/

        //常量池中  ["a","b"]
        //堆中    new String("a") new String("b")
        //String x2 = new String("c") + new String("d");
        /*
        底层调用的是StringBuilder.append("c").append("d").toString();
        得到的结果会存在局部变量表中,并不会存在常量池中
         */
        /*

        System.out.println(x1 == x2);
        //不相等,指向不同*/
        String x2 = new String("c") + new String("d");
        x2.intern();
        String x1 = "cd";
        System.out.println(x1 == "cd");
        System.out.println(x2 == "cd");
    }
}
