package com.wj.springboot.mapper;

//Mapper接口必须和映射文件在同一个目录下

import com.wj.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
//将这个类加入bean工厂当中,可以避免spring在其它类中注入此类时出现警告
@org.apache.ibatis.annotations.Mapper
//添加了@Mapper注解之后这个接口在编译时会生成相应的实现类,进行动态代理
//继承tk.mybatis.mapper.common.Mapper<User>,是针对于User的操作
public interface UserMapper extends Mapper<User> {

    //不使用param注解,如果为多参数的话,只能使用param1,param2,...
    //一个参数就可以使用形参名称
    Integer updateById(@Param("id") Integer id,@Param("name") String name);

    User findById(@Param("id") Integer id);
}
