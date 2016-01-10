package com.chuchujie.webapp.provider.utils;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 建立一个简单的链接
 * @author Administrator
 *
 */
public class JedisUtils {
	/**
	 * 创建本地的jedis
	 * @return
	 */
	public static Jedis createJedis(){
		JedisPool pool=new JedisPool(new JedisPoolConfig(), "127.0.0.1");
		return pool.getResource();
	}
	/**
	 * 根据host port 创建jedis
	 * @param host
	 * @param port
	 * @return
	 */
	public static Jedis createJedis(String host,int port){
		Jedis jedis=new Jedis(host, port);
		return jedis;
	}
	/**
	 * 根据host port password  创建jedis
	 * @param host
	 * @param port
	 * @param password
	 * @return
	 */
	public Jedis createJedis(String host,int port,String password){
		Jedis jedis=new Jedis(host, port);
		if(!StringUtils.isNotBlank(password))
			jedis.auth(password);
		return jedis;
	}
}
