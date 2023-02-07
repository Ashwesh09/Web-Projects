package com.my.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer trasaction_id;
	String name;
	Integer from_acc_no;
	Integer to_acc_no;
	Double amount;
	TransactionType transaction_type;
	
	public Transaction() {
		
	}

	public Transaction(Integer trasaction_id, String name, Integer from_acc_no, Integer to_acc_no, Double amount,
			TransactionType transaction_type) {
		super();
		this.trasaction_id = trasaction_id;
		this.name = name;
		this.from_acc_no = from_acc_no;
		this.to_acc_no = to_acc_no;
		this.amount = amount;
		this.transaction_type = transaction_type;
	}

	public Integer getTrasaction_id() {
		return trasaction_id;
	}

	public void setTrasaction_id(Integer trasaction_id) {
		this.trasaction_id = trasaction_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFrom_acc_no() {
		return from_acc_no;
	}

	public void setFrom_acc_no(Integer from_acc_no) {
		this.from_acc_no = from_acc_no;
	}

	public Integer getTo_acc_no() {
		return to_acc_no;
	}

	public void setTo_acc_no(Integer to_acc_no) {
		this.to_acc_no = to_acc_no;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

	

	
	
	
}