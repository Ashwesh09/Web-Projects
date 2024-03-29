package com.my.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.bank.model.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}