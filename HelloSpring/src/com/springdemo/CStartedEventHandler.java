package com.springdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartedEventHandler implements ApplicationListener<ContextStartedEvent> {
	//Test comment
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("ContextStartedEvent handled");
	}
}