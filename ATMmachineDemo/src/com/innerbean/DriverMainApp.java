package com.innerbean;


public class DriverMainApp {

	public static void main(String[] args) {
		BankAccount savingAcc = new SavingsAccount(123, "Ashwesh", 40000);
		System.out.println("Added Savings Account:\n"+savingAcc);
		BankAccount salaryAcc = new SalaryAccount(124, "Saitama", 200000);
		System.out.println("Added Salary Account:\n"+salaryAcc);
		savingAcc.withdraw(20000.0);
		System.out.println(savingAcc);
		System.out.println();
		
		savingAcc.withdraw(10000.0);
		System.out.println(savingAcc);
		System.out.println();
		
		savingAcc.withdraw(20000.0);
		System.out.println(savingAcc);
		System.out.println();
		
		savingAcc.withdraw(5000.0);
		System.out.println(savingAcc);
		System.out.println();
		
		salaryAcc.withdraw(150000.0);
		System.out.println(salaryAcc);
		System.out.println();
		
		salaryAcc.withdraw(60000.0);
		System.out.println(salaryAcc);
		
	}
}