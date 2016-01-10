package com.chuchujie.webapp.provider;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisTest {
	private ApplicationContext app;
	private ShardedJedisPool pool;

	@Before
	public void before() {
		app = new ClassPathXmlApplicationContext(
				new String[] { "classpath:DubboSpringAll.xml" });
		pool = (ShardedJedisPool) app.getBean("shardedJedisPool");
	}

	@Test
	public void test() {
		// 从池中获取一个Jedis对象
		ShardedJedis jedis = pool.getResource();
		String key = "name";
		String value = "snowolf";
		// 删除数据
		jedis.del(key);
		// 存数据
		jedis.set(key, value);
		// 取数据
		String v = jedis.get(key);
		System.out.println(v);
		// 释放对象池
		jedis.disconnect();
	}
}
