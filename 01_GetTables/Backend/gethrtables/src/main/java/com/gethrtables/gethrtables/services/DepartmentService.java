package com.gethrtables.gethrtables.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gethrtables.gethrtables.models.Department;
import com.gethrtables.gethrtables.repositories.DepartmentRepository;

import jakarta.annotation.Resource;

@Service
public class DepartmentService {
	@Resource(name = "departmentsMySqlRepo")
	private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
		return this.departmentRepository.getAllDepartments();

	}
}
