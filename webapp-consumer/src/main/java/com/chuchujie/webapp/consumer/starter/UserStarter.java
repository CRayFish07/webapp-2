package com.chuchujie.webapp.consumer.starter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuchujie.webapp.common.entity.User;
import com.chuchujie.webapp.common.service.UserService;

public class UserStarter {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbox-im-consumer.xml" });
		context.start();
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setUsername("yxq");
		user.setAge(21);
		user.setPassword("147258");
		user.setAddress("beijing");
		int result = userService.insert(user);
		System.out.println(user.getId());
		System.out.println(result);
	}

	public static void test1(ClassPathXmlApplicationContext context) {

	}

	public static void test2(ClassPathXmlApplicationContext context) {
		UserService userService = (UserService) context.getBean("userService");
	}
}
