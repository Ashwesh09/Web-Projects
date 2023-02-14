package com.gethrtables.gethrtables.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jio.digitalapi.platform.core.service.annotation.DigitalApiDataMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import com.gethrtables.gethrtables.models.Country;

@DigitalApiDataMapper
public class CountryMapper implements RowMapper<Country> {
	public Country mapRow(@NotNull ResultSet result, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCOUNTRY_ID(result.getString("COUNTRY_ID"));
		country.setCOUNTRY_NAME(result.getString("COUNTRY_NAME"));
		country.setREGION_ID(result.getInt("REGION_ID"));
		return country;
	}
}
