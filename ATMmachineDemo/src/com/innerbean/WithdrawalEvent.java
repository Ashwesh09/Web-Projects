package com.innerbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class WithdrawalEvent extends ApplicationEvent {
	private double accBal;
	private double amount;
	public WithdrawalEvent(Object source,double accBal,double amount) {
		super(source);
		this.accBal = accBal;
		this.amount = amount;
	}
	@Override
	public String toString() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return "Amount withdrawn: \t" + amount + "\nAccont Balance : \t" + accBal+ "\nON Time : \t\t" + sdf.format(d);
	}
	
}
