package com.wj;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    private static JedisPool jedisPool = null;
    private static String host;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    static {
        ResourceBundle redis = ResourceBundle.getBundle("redis");
        host = redis.getString("redis.host");
        port = Integer.parseInt(redis.getString("redis.port"));
        maxTotal = Integer.parseInt(redis.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(redis.getString("redis.maxIdle"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}
