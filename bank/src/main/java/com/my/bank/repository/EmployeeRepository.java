package com.my.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.bank.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}