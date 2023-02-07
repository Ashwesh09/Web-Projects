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

import com.my.bank.model.Employee;
import com.my.bank.repository.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping("/employees")
	 public List<Employee> getAllEmplyees() throws SQLException{
		 return employeeRepo.findAll();
	 }
	
	@GetMapping({"/employee/{id}"})
	public Employee showInfo(@PathVariable Integer id) throws SQLException {
		return employeeRepo.getById(id);
	}
	
	
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id) throws SQLException{
		 Employee employee = employeeRepo.getById(id);
		 
		 employeeRepo.deleteById(employee.getid());
		 Map<String	, Boolean> response = new HashMap<>();
		 response.put("deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
	 }
	

		 @PostMapping("/create")
		 public Employee createEmployee(@RequestBody Employee employee) {
			 return employeeRepo.save(employee);
		 }
}
