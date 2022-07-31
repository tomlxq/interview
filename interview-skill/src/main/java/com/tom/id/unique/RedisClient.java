package com.tom.id.unique;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

public class RedisClient {
    public static final int PORT = 10010;
    public static final String HOST = "192.168.238.150";
    private static Jedis jedis;//非切片额客户端连接
    private static JedisPool jedisPool;//非切片连接池
    private static ShardedJedis shardedJedis;//切片额客户端连接
    private static ShardedJedisPool shardedJedisPool;//切片连接池

    static {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    public static ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    /**
     * 初始化非切片池
     */
    private static void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000L);
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config, HOST, PORT);
    }

    /**
     * 初始化切片池
     */
    private static void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000L);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo(HOST, PORT, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }
}
