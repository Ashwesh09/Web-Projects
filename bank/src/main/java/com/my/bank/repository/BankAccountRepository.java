package com.my.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.bank.model.BankAccount;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

}