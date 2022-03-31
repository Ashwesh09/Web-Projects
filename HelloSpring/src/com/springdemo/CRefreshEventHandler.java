package com.springdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CRefreshEventHandler implements ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Test Comments
		System.out.println("Refreshed at :"+event.getTimestamp()+ " msec");
		
	}
}