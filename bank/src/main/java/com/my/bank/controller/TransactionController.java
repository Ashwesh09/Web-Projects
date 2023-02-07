package com.my.bank.controller;

import java.sql.SQLException;
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

import com.my.bank.model.Transaction;
import com.my.bank.repository.TransactionRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction/")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@PostMapping("/create")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteTranscation(@PathVariable Integer id) throws SQLException{
		 Transaction employee = transactionRepository.getById(id);
		 	
		 transactionRepository.deleteById(employee.getTrasaction_id());
		 Map<String	, Boolean> response = new HashMap<>();
		 response.put("deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
	 }
}