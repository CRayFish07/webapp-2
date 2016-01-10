package com.chuchujie.webapp.provider.starter;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SqlProviderStarter {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		// context.addBeanFactoryPostProcessor(configurer);
		context.setConfigLocations(new String[] { "DubboSpringAll.xml" });
		context.refresh();

		context.start();
		try {
			// 按任意键退出
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
