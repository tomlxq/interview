package com.tom.id.unique;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service("redisService")
@Slf4j
public class RedisServiceImpl implements IdUniqueService {
    static Jedis jedis;
    static ShardedJedis shardedJedis;
    static JedisPool jedisPool;
    static ShardedJedisPool shardedJedisPool;

    static {

        jedisPool = RedisClient.getJedisPool();
        shardedJedisPool = RedisClient.getShardedJedisPool();
        jedis = jedisPool.getResource();
        shardedJedis = shardedJedisPool.getResource();
    }

    @Override
    public String generateId() {
        try {
            shardedJedis = shardedJedisPool.getResource();
            String prefix = "test";
            String key = "tl_order_id_" + prefix;
            Long index = shardedJedis.incr(key);
            return prefix + String.format("%1$05d", index);
        } finally {
            shardedJedis.close();
        }
    }


}
