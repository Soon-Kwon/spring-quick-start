package com.springbook.ioc.injection;

import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		// 스프링 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();

		/*
		 * for(String key : addressList.keySet()) {
		 * System.out.println(String.format("%s 주소: %s", key, addressList.get(key))); }
		 */

		
		String address = addressList.get("고길동").toString();
		String address2 = addressList.get("마이콜").toString();

		System.out.println("고길동 주소:" + address);
		System.out.println("마이콜 주소:" + address2);

		/*
		 * for(String address : addressList) { System.out.println(address.toString()); }
		 */

		factory.close();
	}
}
