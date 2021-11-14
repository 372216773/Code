package com.wj;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class JedisTest {
    @Test
    public void testJedis() {
        // 1.连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 2.操作 redis (jedis 对应的方法名与 redis 指令完全相同)
        //jedis.set("name","wj");
        String name = jedis.get("name");
        System.out.println("name: " + name);

        // 3.关闭连接
        jedis.close();
    }

    @Test
    public void testList() {
        // 1.连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 2.操作redis
        jedis.lpush("list", "3", "2", "1");
        jedis.rpush("list", "-1", "-2", "-3");

        List<String> list = jedis.lrange("list", 0, -1);

        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
        Long llen = jedis.llen("list");

        System.out.println("llen: " + llen);


        // 3.关闭连接
        jedis.close();
    }

    @Test
    public void testHash() {
        // 1.连接 redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 2.操作 redis
        jedis.hset("hash", "field1", "a");
        jedis.hset("hash", "field2", "b");
        jedis.hset("hash", "field3", "c");

        Map<String, String> map = jedis.hgetAll("hash");

        System.out.println(map.toString());

        Long hlen = jedis.hlen("hash");
        System.out.println("hlen: " + hlen);
        // 3.关闭连接
        jedis.close();
    }
}
/*
要求:
    1. 设置A,B,C三个用户
    2. A用户限制10次/分调用, B用户限制30次/分调用, C用户不限制

需求分析:
    1. 设定一个服务方法, 用于模拟实际业务调用的服务, 内部采用打印模拟调用
    2. 在业务调用前服务调用控制单元, 内部使用 redis 进行控制, 参照之前的方案
    3. 对调用超限使用异常进行控制, 异常处理设定为打印提示信息
    4. 主程序启动3个线程, 分别代表3中不同用户的调用
 */
