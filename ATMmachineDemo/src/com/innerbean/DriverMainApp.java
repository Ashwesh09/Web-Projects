package com.innerbean;


public class DriverMainApp {

	public static void main(String[] args) {
		BankAccount savingAcc = new SavingsAccount(123, "Ashwesh", 40000);
		System.out.println("Added Savings Account:\n"+savingAcc);
		BankAccount salaryAcc = new SalaryAccount(124, "Saitama", 50000);
		System.out.println("Added Salary Account:\n"+salaryAcc);
		savingAcc.withdraw(20000.0);
		System.out.println(savingAcc);
		
		salaryAcc.deposit(20000.0);
		System.out.println(salaryAcc);
	}
}