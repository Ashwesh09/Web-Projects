package com.innerbean;

import org.springframework.context.ApplicationListener;

public class TransactionEventListener implements ApplicationListener<WithdrawalEvent> {

	@Override
	public void onApplicationEvent(WithdrawalEvent event) {
		sendSMS(event.toString());
	}
	private void sendSMS(String message) {
		System.out.println("Sending sms : \n" + message);
	}
}
