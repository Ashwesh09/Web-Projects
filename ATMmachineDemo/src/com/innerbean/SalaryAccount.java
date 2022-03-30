package com.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SalaryAccount extends BankAccount {

	public SalaryAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}


	@Override
	double withdraw(double amount) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigureData.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		if (amount > 100000) {
			System.out.println("Amount excceds your max withdrawal limit (INR 1,00,000).");
			return this.getAccBalance();
		}
		else if(amount > this.getAccBalance()) {
			System.out.println("Amount exceeds balance.");
			return this.getAccBalance();
		}
		publisher.publish(amount,this.getAccBalance());
		this.setAccBalance(this.getAccBalance() - amount);
		return this.getAccBalance();
	}

	@Override
	double deposit(double amount) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigureData.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		publisher.publish(amount,this.getAccBalance());
		this.setAccBalance(this.getAccBalance() + amount);		
		return this.getAccBalance();
	}
	
}
