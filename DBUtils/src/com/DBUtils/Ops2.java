package com.DBUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

public class Ops2 {

    public static void main(String[] args) throws Exception{

        //创建资源对象
        Properties properties = new Properties();

        //给资源对象加载配置数据 类加载器  获得资源流
        properties.load(Ops2.class.getClassLoader().getResourceAsStream("db.properties"));

        //创建连接池对象,配置数据传给datasource对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //创建DBUtils的核心操作类(queryRunner),操作对象为dataSource
        //new的时候不传参数,就要再加一条语句,setDataSource()赋值
        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "select * from member where id > 0";
        Object query =  queryRunner.query(sql, new MapHandler());
        //System.out.println(query);
        Object query1 = queryRunner.query(sql, new BeanHandler(Demo.class));
        System.out.println(query1);
        Object query2 = queryRunner.query(sql, new ScalarHandler());
        System.out.println(query2);
    }
}
