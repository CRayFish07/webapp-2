package com.chuchujie.webapp.provider.starter;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SqlProviderStarter {

	public static void main(String[] args) {
		System.out.println("加载 dubboxSpring begin");
		PropertyConfigurator.configure(SqlProviderStarter.class
				.getClassLoader().getResource("log4jtcp.properties"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"DubboSpringAll.xml");
		// context.refresh();
		// context.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						sleep(500L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		System.out.println("加载 dubboxSpring end");
	}
}
