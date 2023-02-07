package com.my.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.my.bank.model.Bank;

public class BankMapper implements RowMapper<Bank> {

	@Override
	public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bank bank = new Bank();
		bank.setBankCode(rs.getString("bankCode"));
		bank.setBankName(rs.getString("bankName"));
		bank.setMainOfficeAddress(AddressMapper.processAddress(rs.getString("mainOfficeAddress")));
		return null;
	}

}
