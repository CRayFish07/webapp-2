package com.chuchujie.webapp.provider.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException(
					"applicationContext未注入,请在applicationContext.xml中定义SpringContextHolder");
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean 自动转型为所赋值对象类型 如果有多个Bean符合Class 取出第一个
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		Map beanMaps = applicationContext.getBeansOfType(clazz);
		if (beanMaps != null && !beanMaps.isEmpty())
			return (T) beanMaps.values().iterator().next();
		else
			return null;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean 自动转型为所赋值类型
	 * 
	 * @param name
	 * @return
	 */
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
}
