package com.innerbean;

public class SalaryAccount extends BankAccount {

	public SalaryAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}


	@Override
	double withdraw(double amount) {
		if (amount > 100000) {
			System.out.println("Amount exceds your account balance.");
			return getAccBalance();
		}
		this.setAccBalance(this.getAccBalance() - amount);
		return this.getAccBalance();
	}

	@Override
	double deposit(double amount) {
		this.setAccBalance(this.getAccBalance() + amount);		
		return this.getAccBalance();
	}
	
}
