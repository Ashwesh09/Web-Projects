
package com.my.bank.model;

public class SalaryAccount extends BankAccount {

	public SalaryAccount(Integer accountNo, Integer customerId, AccountType branchCode, Double balance, AccountType type) {
		super();
	}

	double calculateCharges() {
		double charges = 100;
		if (super.getBalance() >= 500 && super.getBalance() < 1000)
			charges += 1000;
		else if (super.getBalance() < 500)
			charges += 1800;
		return charges;
	}

	double calculateInterest() {
		return 0;
	}

}
