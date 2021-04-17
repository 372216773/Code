package com.dadacar;

import com.dadacar.entity.Car;
import com.dadacar.entity.Member;

public class App {

    public static void main(String[] args) throws Exception {

        //创建引导程序
        BootStrap bootStrapApp = new BootStrap();

        //启动程序
        bootStrapApp.startUp();
        //用户验证
        if (!bootStrapApp.login()) {
            System.out.println("登陆失败");
            return;
        }

        //车的类型列表
        bootStrapApp.listCarCategory();

        //选择车的类型,返回类型ID
        Integer categoryId = bootStrapApp.selectCarCategory();

        //类型对应的车的列表
        bootStrapApp.listCar(categoryId);

        //选择具体的车型
        Integer carId = bootStrapApp.selectCar();

        //请输入租用天数
        Integer days = bootStrapApp.readUseDays();

        //生成订单并返回订单ID
        //从全局的共享变量中获取当前登录(下单)的用户
        String nickname = (String) BootStrap.threadLocal.get();

        //查询成员
        Member member = bootStrapApp.findMemberByNickname(nickname);

        //查询具体车辆
        Car car = bootStrapApp.findCarById(carId);

        Integer ordersId = bootStrapApp.genOrders(days, carId, days*car.getPrice(), member.getId());

    }
}
