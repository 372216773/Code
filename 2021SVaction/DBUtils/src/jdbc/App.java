package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/r8401?serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";

        //2.获取连接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        Connection connection1 = DriverManager.getConnection(url, user, password);
        Connection connection2 = DriverManager.getConnection(url, user, password);
        Connection connection3 = DriverManager.getConnection(url, user, password);

        //3.创建操纵数据库的对象
        Statement statement = connection.createStatement();
        Statement statement1 = connection1.createStatement();
        Statement statement2 = connection2.createStatement();
        Statement statement3 = connection3.createStatement();

        System.out.println(statement);
        System.out.println(statement1);
        System.out.println(statement2);
        System.out.println(statement3);
    }
}
