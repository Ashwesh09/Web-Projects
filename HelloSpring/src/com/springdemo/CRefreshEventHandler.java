package com.springdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class CRefreshEventHandler implements ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Test Comment
		System.out.println("Refreshed at :"+event.getTimestamp()+ " msec");
		
	}
}