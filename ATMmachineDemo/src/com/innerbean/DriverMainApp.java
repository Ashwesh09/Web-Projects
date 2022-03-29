package com.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverMainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigureData.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		BankAccount savingAcc = new SavingsAccount(123, "Ashwesh", 40000);
		System.out.println("Added Savings Account:\n"+savingAcc);
		BankAccount salaryAcc = new SalaryAccount(124, "Saitama", 50000);
		System.out.println("Added Salary Account:\n"+salaryAcc);
		savingAcc.withdraw(20000.0);
		publisher.publish(20000.0,savingAcc.getAccBalance());
		System.out.println(savingAcc);
		
		salaryAcc.deposit(20000.0);
		publisher.publish(20000.0,salaryAcc.getAccBalance());
		System.out.println(salaryAcc);
		
		
	}
}