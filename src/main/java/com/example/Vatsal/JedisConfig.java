package com.example.Vatsal;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Configuration
public class JedisConfig {
    public static void main(String args[]){
        JedisPool pool = new JedisPool("localhost",6379);
        Jedis jedis = pool.getResource();
        //jedis.sadd("vegetable","parantha","matar","gobhi");

        Set<String> vegies = jedis.smembers("vegetable");
        for(String veg:vegies){
            System.out.println(veg);
        }
    }
}
