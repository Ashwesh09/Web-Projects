
package com.my.bank.model;

public class SavingsAccount extends BankAccount {
	static final double RATEOFINTEREST = 3.5;

	public SavingsAccount(Integer accountNo, Integer customerId, String branchCode, Double balance, AccountType type) {
		super();
	}

	double calculateCharges() {
		double charges = 100; // Service Charge
		if (super.getBalance() < 5000) {
			charges += ((5000 - super.getBalance()) % 100) * 5 + 75;
		}
		return charges;
	}

	double calculateInterest() {
		return (super.getBalance() * 3) / 100;
	}

}
