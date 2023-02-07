package com.my.bank.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.bank.model.Customer;
import com.my.bank.repository.CustomerRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/customers")
	 public List<Customer> getAllEmplyees() throws SQLException{
		 return customerRepo.getCustomers();
	 }
	
	@GetMapping({"/cutomers/{id}"})
	public Customer showInfo(@PathVariable Integer id) throws SQLException {
		return customerRepo.getCustomerById(id);
	}
	
	
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id) throws SQLException{
		 Customer customer = customerRepo.getCustomerById(id);
		 
		 customerRepo.deleteCustomerById(customer.getCustomerId());
		 Map<String	, Boolean> response = new HashMap<>();
		 response.put("deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
	 }
	@PostMapping(path="/deleteForm" ,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String deleteCustomerForm(@RequestParam Integer customerId) throws SQLException {
		customerRepo.deleteCustomerById(customerId);
		return "Deleted Customer No:"+ customerId;
	}
	
	
	@PostMapping("/create")
	 public Customer createCustomers(@RequestBody Customer customer) throws SQLException {
		 return customerRepo.createCustomer(customer);
	 }
}
