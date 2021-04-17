package com.wj.goods.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.util.Properties;

/*
创建数据连接池
创建DBUtils的核心操作类
单例模式创建唯一的池,操作对象
所有对象都只有一个
 */
public class JdbcUtil {

    private static Properties properties;
    private static DataSource dataSource;
    private static QueryRunner queryRunner;
    //不允许外部通过构造方法访问类
    private JdbcUtil(){}

    static {
        try {
            //创建资源对象
            properties = new Properties();
            //将资源加载到资源对象中
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            //创建连接池对象,需要引入Druid.jar,连接数据库的包,DBUtils的包(对原始的jdbc的封装)
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            //创建DBUtils的核心操作类
            queryRunner = new QueryRunner(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    创建全局唯一的查询器
     */
    public static QueryRunner getQueryRunner() {
        return queryRunner;
    }

}
