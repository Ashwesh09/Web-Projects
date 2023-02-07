package com.gethrtables.gethrtables.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gethrtables.gethrtables.models.Country;


public class CountryMapper implements RowMapper<Country> {
	public Country mapRow(ResultSet result, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCOUNTRY_ID(result.getString("COUNTRY_ID"));
		country.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
		country.setREGION_ID(result.getInt("REGION_ID"));
		return country;
	}
}
