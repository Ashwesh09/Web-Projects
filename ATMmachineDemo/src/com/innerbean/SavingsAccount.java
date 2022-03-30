package com.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}


	@Override
	double withdraw(double amount) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigureData.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		if(amount > 30000.0) {
			System.out.println("Amount exceeds Max withdrawal limit (INR 30,000).");
			return this.getAccBalance();
		}
		else if(amount > this.getAccBalance()) {
			System.out.println("Amount exceeds balance.");
			return this.getAccBalance();
		}
		publisher.publish(amount,this.getAccBalance());
		this.setAccBalance(this.getAccBalance()- amount);
		return this.getAccBalance();
		}

	@Override
	double deposit(double amount) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigureData.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		if(amount > 1000000.0) {
			System.out.println("Deposit limit exceeds INR 1000000.0. Cannot Deposite");
			return this.getAccBalance();
		}
		publisher.publish(amount,this.getAccBalance());
		this.setAccBalance( amount + this.getAccBalance());
		return 0;
	}
	
}
