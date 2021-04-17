package com.wj;

public class Teacher{

    public void method(){
        Student s=new Student();
        s.name="wj";
        s.sex="male";
        s.stuId=1;
        //s.age是Student类私有,Teacher类不能访问
    }

}