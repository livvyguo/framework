package com.lvy.appexec.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * Created by livvy on 14-8-26.
 */
public class Main {
    public static void main(String[] args) {
//
//        Jedis jedis = new Jedis("localhost");
//        jedis.connect();
//
//        for (int i = 0; i < 200; i++) {
//            jedis.set("key" + i, "value" + i);
//        }
//        jedis.ping();
//        jedis.quit();
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxActive(100);

        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = pool.getResource();
        jedis.set("foo", "bar");
        String foo = jedis.get("foo");
        System.out.println(foo);
        Set<String> keys = jedis.keys("*");
        for(String s : keys) {
            System.out.println(s);
            Long del = jedis.del(s);
            System.out.println(del);
        }
        pool.returnResource(jedis);
    }
}
