package com.exec.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisTestor {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.187.129", 18926);
        try {
            jedis.auth("root");
            jedis.select(2);
            System.out.println("Redis连接成功");

            //字符串
            jedis.set("sn", "7781-9938");
            String sn = jedis.get("sn");
            System.out.println(sn);
//            jedis.mset(new String[]{"title", "婴幼儿奶粉", "num", "20"});
            jedis.mset("title", "婴幼儿奶粉", "num", "20");
            List<String> goods = jedis.mget("sn", "title", "num");
            System.out.println(goods);
            Long num = jedis.incr("num");
            System.out.println(num);

            //Hash
            jedis.hset("student:3312", "name", "张晓明");
            String name = jedis.hget("student:3312", "name");
            System.out.println(name);
            Map<String, String> studentMap = new HashMap<String, String>();
            studentMap.put("name", "李兰");
            studentMap.put("age", "18");
            studentMap.put("id", "3313");
            jedis.hmset("student:3313", studentMap);
            Map<String, String> smap = jedis.hgetAll("student:3313");
            System.out.println(smap);

            //List
            jedis.del("letter");
            jedis.rpush("letter", "d", "e", "f");
            jedis.lpush("letter", "c", "b", "a");
            List<String> letter = jedis.lrange("letter", 0, -1);
            System.out.println(letter);
            jedis.lpop("letter");
            jedis.rpop("letter");
            letter = jedis.lrange("letter", 0, -1);
            System.out.println(letter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
