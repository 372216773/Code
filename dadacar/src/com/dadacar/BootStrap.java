package com.dadacar;

import com.dadacar.util.DBUtils;
import com.dadacar.entity.*;
import java.sql.*;
import java.util.Scanner;

public class BootStrap {

    //两个方法都要用到,设为静态属性
    public static Connection connection;
    //thread用于保存当前线程的共享变量
    public static ThreadLocal threadLocal = new ThreadLocal();

    public Boolean login() throws Exception {
        System.out.println("欢迎使用哒哒租车系统");
        System.out.println("________________");

        System.out.println("请输入用户名:");
        String nickname = new Scanner(System.in).next();

        System.out.println("请输入密码:");
        String password = new Scanner(System.in).next();

        //执行sql语句,验证是否与数据库中的数据相同
        String sql = "select count(*) as count from member where nickname=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,nickname);
        preparedStatement.setString(2,password);

        //获取结果对象
        ResultSet resultSet = preparedStatement.executeQuery();
        //结果肯定有下一条 0,1,2,3......
        resultSet.next();
        //从count字段中获取数据,以long的形式接收
        long count = resultSet.getLong("count");
        if (count > 0) {
            //获取加载的对象,并输出加载对象的nickname属性
            threadLocal.set(nickname);
            return true;
        } else {
            return false;
        }
    }

    public void startUp() {
        System.out.println("程序正在启动......");
        connection = DBUtils.getConnection();
    }

    //车的类型列表
    public void listCarCategory() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category");
            System.out.println("类型ID\t类型");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "\t\t" + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //车的类型
    public Integer selectCarCategory() {
        System.out.println("请输入租用的车辆类型的ID:");
        return new Scanner(System.in).nextInt();
    }

    //对应车的具体车型
    public void listCar(Integer categoryId) {
        String sql = "select car.id,car.name,car.`price`,car.`zkl`,car.`zhl`,category.name categoryName from car inner join category on car.`category_id`=category.id where car.`category_id`=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("车辆ID\t车辆名称\t车辆单价\t载客量\t载货量\t所属类型");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer price = resultSet.getInt("price");
                Integer zkl = resultSet.getInt("zkl");
                Integer zhl = resultSet.getInt("zhl");
                String categoryName = resultSet.getString("categoryName");

                System.out.println(id + "\t\t" + name + "\t" + price + "\t\t" + zkl + "\t\t" + zhl + "\t\t" + categoryName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //具体车型
    public Integer selectCar() {
        System.out.println("请输入租用车辆的具体车型ID:");
        return new Scanner(System.in).nextInt();
    }

    //租用天数
    public Integer readUseDays() {
        System.out.println("请输入租用天数:");
        return new Scanner(System.in).nextInt();
    }

    //查找用户
    public Member findMemberByNickname(String nickname) {
        String sql = "select * from member where nickname=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                return new Member(id, nickname, null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //生成订单
    public Integer genOrders(Integer days, Integer carId, int totalPrice, Integer memberId) {

        String sql = "insert into orders(days,total_price,member_id,car_id)values(?,?,?,?)";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, days);
            preparedStatement.setInt(2, totalPrice);
            preparedStatement.setInt(3, memberId);
            preparedStatement.setInt(4, carId);
            preparedStatement.execute();
            System.out.println("生成订单成功!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //根据车辆ID查询具体的车辆信息
    public Car findCarById(Integer carId) {
        String sql = "select * from car where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = new Car();
            if (resultSet.next()) {
                car.setId(carId);
                car.setName(resultSet.getString("name"));
                car.setPrice(resultSet.getInt("price"));
                car.setZhl(resultSet.getInt("zhl"));
                car.setZkl(resultSet.getInt("zkl"));
                return car;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
