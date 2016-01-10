package com.chuchujie.webapp.consumer.starter;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuchujie.webapp.common.entity.ItemRates;
import com.chuchujie.webapp.common.service.ItemRatesService;

public class ItemRatesStarter {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"dubbox-im-consumer.xml"});
		context.start();
		ItemRatesService itemRatesService=(ItemRatesService) context.getBean("itemRatesService");
		List<ItemRates>itemRates=itemRatesService.selectByProductId(1000233051);
		System.out.println(itemRates.get(0));
	}
}
