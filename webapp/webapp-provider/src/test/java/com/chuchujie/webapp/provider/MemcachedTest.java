package com.chuchujie.webapp.provider;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuchujie.webapp.provider.utils.SpringContextHolder;
import com.danga.MemCached.MemCachedClient;

public class MemcachedTest {
	MemCachedClient memcachedClient;

	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "DubboSpringAll.xml" });
		memcachedClient = SpringContextHolder.getBean("memcachedClient");
	}

	@Test
	public void test() {
		memcachedClient.set("name", "yxq");
		System.out.println(memcachedClient.get("name"));
	}
}
