package com.chuchujie.webapp.provider.utils;

import com.danga.MemCached.MemCachedClient;

public class MemcachedUtils {
	public static MemCachedClient getMemCachedClient(){
		return SpringContextHolder.getBean("memcachedClient");
	}
}
