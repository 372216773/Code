package com.wj;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        //创建SqlSessionFactory 对象
        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object o = sqlSession.selectList("test.selectByAge", 6);

        System.out.println(o);
    }
}
