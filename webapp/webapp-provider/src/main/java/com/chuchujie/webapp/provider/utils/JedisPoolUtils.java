package com.chuchujie.webapp.provider.utils;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 建立jedis连接池
 * 
 * @author Administrator
 *
 */
public class JedisPoolUtils {
	private static JedisPool pool;

	private JedisPoolUtils() {
	}

	private static class JeddisPoolHolder {
		private static final JedisPoolUtils JEDISPOOLUTILS = new JedisPoolUtils();
	}

	public static final JedisPoolUtils getInstance() {
		return JeddisPoolHolder.JEDISPOOLUTILS;
	}

	/**
	 * 
	 */
	private void createJedisPool() {
		ResourceBundle bundle = ResourceBundle.getBundle("redis/redis");
		if (bundle == null)
			throw new IllegalArgumentException(
					"[redis.properties] is not found!");
		// 建立连接池配置参数
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置最大连接数
		config.setMaxTotal(Integer.valueOf(bundle
				.getString("redis.pool.maxTotal")));
		// 设置空间连接数
		config.setMinIdle(Integer.valueOf(bundle
				.getString("redis.pool.maxIdle")));
		// 设置最大阻塞数 时间为毫秒
		config.setMaxWaitMillis(Integer.valueOf(bundle
				.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config, bundle.getString("redis.ip"),
				Integer.valueOf(bundle.getString("redis.port")));
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private synchronized void poolInit() {
		if (pool == null)
			createJedisPool();
	}

	/**
	 * 获取一个jedis 对象
	 * 
	 * @return
	 */
	public Jedis getJedis() {
		if (pool == null)
			poolInit();
		return pool.getResource();
	}

	/**
	 * 归还一个连接
	 * 
	 * @param jedis
	 */
	public void returnJedis(Jedis jedis) {
		pool.returnResource(jedis);
	}
}