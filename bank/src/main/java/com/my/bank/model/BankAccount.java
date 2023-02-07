package com.my.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
	
	@Id
	Integer accountNo;
	Integer customerId;
	AccountType accountType;
	String branchCode;
	Double balance;
	
	public BankAccount() {
		
	}

	public BankAccount(Integer accountNo, Integer customerId, AccountType accountType, String branchCode,
			Double balance) {
		super();
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.accountType = accountType;
		this.branchCode = branchCode;
		this.balance = balance;
	}

	public Integer getaccountNo() {
		return accountNo;
	}

	public void setaccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public AccountType getaccountType() {
		return accountType;
	}

	public void setaccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getbranchCode() {
		return branchCode;
	}

	public void setbranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", customerId=" + customerId + ", accountType=" + accountType
				+ ", branchCode=" + branchCode + ", balance=" + balance + "]";
	}

	

	
	
}