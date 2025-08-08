package org.example;

import redis.clients.jedis.Jedis;

public class RedisConnector {
    public static void main(String[] args) {

        String redisHost = "like98100-redis-cache-moypae.serverless.apn2.cache.amazonaws.com"; // or localhost
        int redisPort = 6379;

        try (Jedis jedis = new Jedis(redisHost, redisPort)) {
            System.out.println("Connected to Redis");

            // 1. 간단한 Key-Value 저장
            jedis.set("user:1", "like98100");
            jedis.set("user:2", "byeongchang");
            jedis.set("user:3", "bottlespear");

            String value = jedis.get("user:1");
            System.out.println("GET user:1 => " + value);

            // 2. Hash 타입 사용
            jedis.hset("user:100", "name", "Alice");
            jedis.hset("user:100", "role", "admin");
            System.out.println("Hash user:100 => " + jedis.hgetAll("user:100"));

            // 3. List 타입 사용
            jedis.lpush("tasks", "task1", "task2", "task3");
            System.out.println("List tasks => " + jedis.lrange("tasks", 0, -1));

            // 4. Set 타입 사용
            jedis.sadd("fruits", "apple", "banana", "orange");
            System.out.println("Set fruits => " + jedis.smembers("fruits"));

            // 5. Key 삭제
            jedis.del("user:1");
            System.out.println("Deleted key user:1, Exists? " + jedis.exists("user:1"));

            System.out.println("All users: " + jedis.keys("user:*"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

