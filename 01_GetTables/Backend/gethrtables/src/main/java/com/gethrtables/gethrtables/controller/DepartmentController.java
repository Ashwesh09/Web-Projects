package com.gethrtables.gethrtables.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gethrtables.gethrtables.models.Department;
import com.gethrtables.gethrtables.repositories.DepartmentRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
	private DepartmentRepository departmentRepository;
    
    @GetMapping
    public List<Department> getAllDeparmtents() throws SQLException {
        return Collections.unmodifiableList(departmentRepository.getAllDepartments());
    }
}
