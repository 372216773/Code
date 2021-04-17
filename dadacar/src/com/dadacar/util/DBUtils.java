package com.dadacar.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/* @Title
 * @Description
 * @Param mysql操作的封装
 * @return
 * @Author WJ
 * @Date 11:03 2021/1/27
*/
/*
工具类,构造方法设为private,通过类名访问
 */
public class DBUtils {

    private static Properties prop = new Properties();
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    //构造方法私有化,外界无法通过新建对象获取
    //需要通过类获取到方法,所以方法斗为静态方法
    private DBUtils() {}

    //加载驱动
    static {
        try {
        //初始化配置信息
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("mysql.properties");

            prop.load(inputStream);
            URL = prop.getProperty("url");
            USER = prop.getProperty("user");
            PASSWORD = prop.getProperty("password");

            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.err.println("加载驱动异常,找不到驱动文件");
        } catch (FileNotFoundException e) {
            System.err.println("初始化配置异常");
        } catch (IOException e) {
            System.err.println("IP异常");
        }
    }

    //获取连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //对照信息是否正确
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e) {
            System.err.println("获取连接对象异常" + e.getMessage());
        }
        return connection;
    }

    //释放资源

    /**
     *
     * @param resultSet 结果集对象
     * @param statement statement对象
     * @param connection 连接对象
     */
    public static void closeAll(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
