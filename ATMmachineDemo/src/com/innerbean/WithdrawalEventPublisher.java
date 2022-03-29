package com.innerbean;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	public void publish(double amount,double accBal) {
		WithdrawalEvent we = new WithdrawalEvent(this,amount,accBal);
		this.publisher.publishEvent(we);
	}
}
