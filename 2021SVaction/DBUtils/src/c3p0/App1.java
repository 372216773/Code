package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//配置默认配置文件(c3p0-config.xml),c3p0默认会加载配置文件
public class App1 {
    //池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static void main(String[] args) throws SQLException, IOException {

        //获取连接对象
        Connection connection = dataSource.getConnection();
        Connection connection1 = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        //获取操作数据库的对象,还是jdbc
        Statement statement = connection.createStatement();
        System.out.println(statement);
    }
}
