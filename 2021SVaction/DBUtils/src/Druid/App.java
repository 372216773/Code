package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(App.class.getClassLoader().getResourceAsStream("db_druid.properties"));

        //获取连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //还是使用jdbc来操作数据库
    }
}
