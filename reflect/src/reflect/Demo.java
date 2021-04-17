package reflect;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {

//        //创建一个实例
//        reflect.Demo demo = new reflect.Demo();
//        //通过实例,可以获取实例所属的类的 类对象
//        demo.getClass();
//
//        //使用类的class属性来获取类对象
//        Class class1 = reflect.Demo1.class;
//
//        //获取类对象
//        Class Class2 = Class.forName("reflect.Demo1");
//
//        //通过反射获取其类对象(类名)
//        Class classPhone = reflect.Person.class;
//
//        //可以通过类对象获取类中定义的属性对象
//        //Field获取全部的公有的属性对象
//        Field[] fields = classPhone.getFields();
//
//        Class classPerson = reflect.Person.class;
//
//        //获取公有属性和超类的公有属性
//        Class classStudent = Class.forName("reflect.Student");
//        for (Field field:classStudent.getFields()) {
//            System.out.println(field.getName());
//        }
//        System.out.println("--------------------------------");
//        //获取所有属性,但获取不到超类属性
//        for (Field field:classStudent.getDeclaredFields()) {
//            System.out.println(field.getName());
//        }
//
//        Class studentClass = reflect.Student.class;
//
//        System.out.println("--------------------------------");
//        //获取到指定的(name)公有属性和超类的公有属性
//        Field field = studentClass.getField("name");
//        System.out.println(field);
//
//        //获取指定的(name)本类的所有属性,不能获取超类的属性
//        Field field1 = studentClass.getDeclaredField("nn");
//        System.out.println(field1);
//        System.out.println("---------------------------------------------");
//        //给属性对象赋值
//        field.set();

        Class studentClass1 = Student.class;

        //获取所有的公有方法对象(包含继承的公有方法对象,即还包含Object类的方法对象)
        Method[] methods = studentClass1.getMethods();
        for (Method method:methods) {
            System.out.println(method.getName());
        }
        System.out.println("--------------------------------");
        //获取本类所有方法
        Method[] declaredMethod = studentClass1.getDeclaredMethods();
        for (Method method:declaredMethod) {
            method.setAccessible(true);
            System.out.println(method.getName());
        }

//        System.out.println("--------------------------------");
//        Method method = reflect.Person.class.getDeclaredMethod("talk");
//        System.out.println(method.getName());
//
//        //使用反射创建对象
//        Class personClass = reflect.Person.class;
//        reflect.Person person = (reflect.Person) personClass.newInstance();//返回类型为Object类型

        //
    }
}
//带有Declared的方法可以获取到本类的全部属性对象,但不能获取到超类的属性对象
//不带Declared的方法可以获取本类和超类的所有共有属性对象,所有私有属性对象都不能获取
