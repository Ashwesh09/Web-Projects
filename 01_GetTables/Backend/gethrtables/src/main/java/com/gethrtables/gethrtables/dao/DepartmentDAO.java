package com.gethrtables.gethrtables.dao;

import java.sql.SQLException;
import java.util.List;

import com.gethrtables.gethrtables.models.Department;

public interface DepartmentDAO {
    public List<Department> getAllDepartments() throws SQLException;
}
