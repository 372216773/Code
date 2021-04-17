package com.wj.mapper;

import com.wj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//mybatis中的mapper相当于Dao
//mybatis当中都是接口类型的
public interface UserMapper {
    User selectById(Integer id);

    //where-if
    List<User> listByUser(User user);

    //foreach接收多个参数
    List<User> ListByIdWithForeach(List<Integer> list);

    Integer updateUser(User user);

    List<User> selectById1(User user);

    //不使用注解,在sql中使用的话,就只能用param1,param2代替,没有做到见名知意
    List<User> selectByIdAndName(@Param("id") Integer id,@Param("name") String name);

    //多表联查,一对一,一对多
    List<User> listById(Integer id);
}
