package com.my.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.bank.model.BankAccount;
import com.my.bank.repository.BankAccountRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
	
	
	@Autowired
	 private BankAccountRepository bankAccountRepository;
	 
	 //get all bankAccount
	 @GetMapping("/bankAccounts")
	 public List<BankAccount> getAllEmplyees(){
		 return bankAccountRepository.findAll();
	 }
	 
	 
	//Create bankAccount rest api
	 @PostMapping("/create")
	 public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
		 return bankAccountRepository.save(bankAccount);
	 }
	 
	 
	//delete rest api
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		 BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();
		 
		 bankAccountRepository.delete(bankAccount);
		 Map<String	, Boolean> response = new HashMap<>();
		 response.put("deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
	 }
}