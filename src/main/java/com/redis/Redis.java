package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: 张扬
 * @Date: 2019/1/11 15:12
 * @Description:
 */
public class Redis {

    public  static  void main(String args[]) throws InterruptedException {
        JedisPool jedisPool = new JedisPool();
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        jedisPool = new JedisPool(config, "192.168.13.121",6379,2000);
        Jedis jedis = jedisPool.getResource();
//        jedis.set("zhangyang","是好人");
        System.out.println(jedis.get("zhangyang"));
    }

}
