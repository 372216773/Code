package com.wj;

import com.wj.mapper.UserMapper;
import com.wj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //当进行添加操作时,需要设置自动提交
        //最简单的操作
        /*SqlSession sqlSession = sqlSessionFactory.openSession(true);

        List<Object> objects = sqlSession.selectList("test.selectById", 1);
        System.out.println(objects);
        List<Object> wj = sqlSession.selectList("test.selectByName", "wj");
        System.out.println(wj);
        List<Object> list = sqlSession.selectList("test.likeByName", "w");
        System.out.println(list);
        User user = new User("王晶晶",1);

        int insert = sqlSession.insert("test.insertUser", user);
        System.out.println(insert);*/

        //原始操作:
        /*
        1.dao包中UserMapper接口和impl包,impl包下的实现类(内含sqlSession的操作)
        2.资源包下的sqlMap包下的UserMapper,配置对应接口的抽象方法,以及sql语句
        * */
        /*UserMapperImpl userMapper = new UserMapperImpl(sqlSessionFactory);
        User user = userMapper.selectById(1);
        System.out.println(user);
        List<User> userList = userMapper.selectByName("wj");
        System.out.println(userList);
        List<User> users = userMapper.likeByName("w");
        System.out.println(users);
        User user1 = new User("ggg",34);
        userMapper.insertUser(user1);*/

        //mybatis代理的方式开发(不用写实现类,但必须遵守mybatis的规范)
        /*
        mapper包下接口(抽象方法)与同名的xml文件(对应接口,编写sql语句)
         */
        /*//创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //返回jdk底层生成的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行业务
        User user = mapper.selectById(1);
        System.out.println(user);*/

        //动态sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //where-if
        User user = new User();
        user.setAge(22);
        /*user.setName("wj");*/
        user.setId(4);
        List<User> users = mapper.listByUser(user);
        System.out.println("找一个对象,名字叫做wj,年龄22的人:" + users);

        //where-foreach
        List<User> users1 = mapper.ListByIdWithForeach(Arrays.asList(1, 2, 3, 4));
        System.out.println("找id为1,2,3,4的人:"+users1);

        //update
        User user1 = new User();
        /*user1.setId(2);*/
        user1.setName("newName");
        Integer integer = mapper.updateUser(user1);
        System.out.println(integer);

        //choose-when
        User user2 = new User();
        /*user2.setName("wj");*/
        user2.setId(2);
        List<User> users2 = mapper.selectById1(user2);
        System.out.println(users2);

        //多个参数
        List<User> users3 = mapper.selectByIdAndName(3, "wj");
        System.out.println(users3);

        //多表联查,一对一,一对多
        List<User> users4 = mapper.listById(2);
        System.out.println(users4);


    }
}
