package com.innerbean;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}


	@Override
	double withdraw(double amount) {
		if(amount > 30000.0) {
			System.out.println("Amount exceeds balance.");
			return this.getAccBalance();
		}
		this.setAccBalance(this.getAccBalance()- amount);
		return this.getAccBalance();
		}

	@Override
	double deposit(double amount) {
		if(amount > 1000000.0) {
			System.out.println("Deposit limit exceeds INR 1000000.0. Cannot Deposite");
			return this.getAccBalance();
		}
		this.setAccBalance( amount + this.getAccBalance());
		return 0;
	}
	
}
