package com.my.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.my.bank.model.Transaction;

public interface TransactionDAO {
	public Boolean deposit(Double amount, String accNo) throws SQLException;

	public Boolean withdraw(double amount, String accNo) throws SQLException;

//add start date and end date
	public List<Transaction> showTransactions() throws SQLException;
}
