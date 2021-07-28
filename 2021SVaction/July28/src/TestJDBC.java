import java.sql.*;

public class TestJDBC {

    /*
    jdbc连接数据库的步骤:
    1、加载jdbc驱动程序
    2、创建数据库的连接
    3、创建preparedStatement
    4、执行SQL语句
    5、遍历结果集
    6、处理异常，关闭JDBC对象资源.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载JDBC驱动程序(受查异常)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接url,username,password
        String url = "jdbc:mysql://localhost:3306/r8401?serverTimezone=Asia/Shanghai";    //定位
        String username = "root";
        String password = "root";


        //java程序就相当于客户端，只有先连接上数据库服务，才能对数据库进行操作

        //每次连接数据库,断开数据库,很耗费资源
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建连接池对象
        //MysqlDataSource dataSource = new MysqlDataSource();
        //dataSource.setUrl(url);
        //从连接池中获取闲置的连接对象
        //Connection connection = dataSource.getConnection(username, password);

        //3.执行SQl语句
        String sql = "select * from user where nickname = ?";
        String name = "灰太狼";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getInt(3));
        }

    }
}
