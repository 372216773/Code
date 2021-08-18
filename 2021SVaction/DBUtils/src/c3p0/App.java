package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//使用properties配置文件设置
public class App {
    //池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(App.class.getClassLoader().getResourceAsStream("db_c3p0.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setMaxPoolSize(20);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        //获取操作数据库的对象,还是jdbc
        Statement statement = connection.createStatement();
        System.out.println(statement);
    }
}
