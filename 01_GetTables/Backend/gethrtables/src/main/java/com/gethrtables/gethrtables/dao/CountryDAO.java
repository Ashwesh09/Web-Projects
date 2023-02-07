package com.gethrtables.gethrtables.dao;

import java.sql.SQLException;
import java.util.List;

import com.gethrtables.gethrtables.models.Country;

public interface CountryDAO {
	public List<Country> getAllCountry() throws SQLException;

	public Boolean addCountry(Country country);

	public Country getCountryByID(String countryID);
}
