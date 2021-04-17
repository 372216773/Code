package com.wj.goods.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/*

 */
public class JdbcUtil {

    private static DruidDataSource druidDataSource;

    //配置信息只需要执行一次
    static {
        try {
            //创建配置文件对象
            Properties properties = new Properties();
            //将xml文件中的配置信息加载到配置文件对象中
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            //连接池读入配置信息,并创建连接池对象
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static QueryRunner getQueryRunner() {
        //向数据库操作类中传入需要操作的数据库连接池
        return new QueryRunner(druidDataSource);
    }

}
