package com.wj;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class Service {
    private String id;
    private int num;

    public Service(String id, int num) {
        this.id = id;
        this.num = num;
    }

    //控制单元-->控制 business 的调用
    public void service() {
        // 1.连接 redis
        //Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = JedisUtils.getJedis();

        // 2.操作
        String value = jedis.get("compid:" + id);
        System.out.println("value: " + value);
        try {
            if (value == null) {
                //不存在,创建该值 (这个用户在规定时间内只允许调用num次,使用异常操作)
                jedis.setex("compid:" + id, 20, Long.MAX_VALUE - num + "");
            } else {
                //存在,自增,调用业务
                Long val = jedis.incr("compid:" + id);
                business(id, num - (Long.MAX_VALUE - val));
            }
        } catch (JedisDataException e) {
            System.out.println("使用已经到达使用上限");
            return;
        } finally {
            // 3.关闭连接
            jedis.close();
        }
    }

    //业务操作
    public void business(String id, long val) {
        System.out.println("用户: " + id + "-正在进行业务操作");
        System.out.println("已使用次数: " + val);
    }
}

class MyThread extends Thread {
    Service sc;

    public MyThread(String name, int num) {
        sc = new Service(name, num);
    }

    public void run() {
        while (true) {
            sc.service();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("初级用户", 10);
        MyThread myThread1 = new MyThread("高级用户", 30);

        myThread.start();
        myThread1.start();
    }
}
