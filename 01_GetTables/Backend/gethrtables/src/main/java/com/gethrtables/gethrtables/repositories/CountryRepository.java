package com.gethrtables.gethrtables.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jio.digitalapi.platform.core.service.annotation.DigitalApiDataService;
import org.springframework.stereotype.Repository;

import com.gethrtables.gethrtables.dao.CountryDAO;
import com.gethrtables.gethrtables.models.Country;
import com.gethrtables.gethrtables.util.DatabaseConnection;

@DigitalApiDataService
public class CountryRepository implements CountryDAO {
    Connection conn;
    public CountryRepository() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }
        

        @Override
        public List<Country> getAllCountry() throws SQLException {
            String sql = "SELECT `COUNTRY_ID`,`COUNTRY_NAME`,`REGION_ID` FROM countries";
            try(Statement st = conn.createStatement()){
            List<Country> wkr = new ArrayList<>();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                wkr.add(new Country(rs.getString("country_id"),rs.getString("country_name"),rs.getInt("region_id")));
            }
            return wkr;
        }
    }

    @Override
    public Boolean addCountry(Country country) {
            String countryID = country.getCOUNTRY_ID();
            String countryName = country.getCOUNTRY_NAME();
            int regionID = country.getREGION_ID();
        String sql = String.format("INSERT INTO countries VALUES('%s','%s',%d);",
                countryID,
                countryName,
                regionID);
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Country getCountryByID(String countryID) {
        String sql = "SELECT `COUNTRY_ID`,`COUNTRY_NAME`,`REGION_ID` FROM countries WHERE `COUNTRY_ID` = ?;";
        Country wkr = null;
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, countryID);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                wkr = new Country(r.getString("COUNTRY_ID"),r.getString("COUNTRY_NAME"), r.getInt("REGION_ID"));
            }
        } catch (SQLException e) {
            return null;
        }
        return wkr;
    }
}
