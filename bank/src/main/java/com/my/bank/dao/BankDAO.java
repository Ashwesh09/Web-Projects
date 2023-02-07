package com.my.bank.dao;

import java.sql.SQLException;

import com.my.bank.model.Bank;

public interface BankDAO {

	Boolean createBankAccount(Bank bank) throws SQLException;
	
	
}
