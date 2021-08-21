package com.wj.servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtil {

    private static QueryRunner queryRunner;

    private JDBCUtil() {
    }

    //当这个类加载时
    static {
        Properties properties = new Properties();
        try {
            properties.load(HelloServlet.class.getClassLoader().getResourceAsStream("db.properties"));
            //创建池
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //从池中获取连接对象
            //Connection connection = dataSource.getConnection();
            //创建DBUtils核心操作类,需要池
            queryRunner = new QueryRunner(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QueryRunner getQueryRunner () {
        return queryRunner;
    }
}
