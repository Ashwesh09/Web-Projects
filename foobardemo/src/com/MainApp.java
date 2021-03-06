package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Bar bar = (Bar) context.getBean("Bar");
		bar.setFoo(new Foo("Ashwesh"));
		bar.processFooName();
	}
}

