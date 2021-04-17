public class MyString {
    public static void main(String[] args) {

        int[] array=null;
        String str=myString(array);
        System.out.println(str);

    }
    public static String myString(int[] array) {
        String str=null;
        if (array==null) {
            return null;
        }
        if (array.length==0) {
            return "[]";
        }
        for (int i = 0; i < array.length; i+=2) {
            if (i==0) {
                str="[";
            }
            str=i<array.length-1?str + array[i] + ", ":str + array[i] + "]";
        }
        return str;
    }
}
