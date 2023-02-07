
package com.my.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.my.bank.model.Branch;

public class BranchMapper implements RowMapper<Branch> {

	@Override
	public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
		Branch branch = new Branch();
		branch.setBranchCode(rs.getString("branchCode"));
		branch.setAddress(AddressMapper.processAddress(rs.getString("address")));
		branch.setManager(rs.getString("manager"));
		branch.setHeadOffice(AddressMapper.processAddress(rs.getString("headOffice")));
		branch.setBankCode(rs.getString("bankCode"));
		return branch;
	}

}
