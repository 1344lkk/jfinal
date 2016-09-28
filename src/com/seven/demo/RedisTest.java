package com.seven.demo;

import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;

public class RedisTest {
	public static void main(String[] args) {
		RedisPlugin plugin = new RedisPlugin("myRedis", "localhost");
		plugin.start();
		Redis.use().set("key", "123");
		System.out.println(Redis.use().get("key"));
	}
}
