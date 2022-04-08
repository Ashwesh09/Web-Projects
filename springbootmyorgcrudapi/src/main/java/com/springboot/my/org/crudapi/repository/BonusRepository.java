package com.springboot.my.org.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDAO;
import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.util.DatabaseConnection;




@Repository
public class BonusRepository implements BonusDAO{
    Connection conn;
    public BonusRepository() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }
    @Override
    public Boolean create(Bonus w) throws SQLException {
        Integer workerRefId = w.getWorkerRefId();
        Integer amount = w.getBonusAmount();
        Date date = w.getBonusDate();
        String sql = String.format("INSERT INTO Bonus VALUES(%d,'%s','%s');", 
        		workerRefId,
        		amount,
        		date);
        try (Statement statement = conn.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }

    }
    @Override
    public Boolean delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Bonus WHERE worker_ref_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            System.out.println(res + " row/s affected.");
            return res == 1;
        }

    }

    @Override
    public Bonus getBonusById(Integer id) throws SQLException {
        String sql = "SELECT worker_ref_id ,bonus_amount,bonus_date FROM Bonus WHERE worker_ref_id = ?";
        Bonus wkr = null;
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                wkr = new Bonus(r.getInt("worker_ref_id"),r.getInt("bonus_amount"),r.getDate("bonus_date"));
            }
        }
        return wkr;
    }

    @Override
    public List<Bonus> getAllBonuses() throws SQLException {
         String sql = "SELECT worker_ref_id ,bonus_amount,bonus_date FROM Bonus";
         try(Statement st = conn.createStatement()){
         List<Bonus> wkr = new ArrayList<>();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
             wkr.add(new Bonus(rs.getInt("worker_ref_id"),rs.getInt("bonus_amount"),rs.getDate("bonus_date")));
         }
         return wkr;
        }
    }

    @Override
    public Boolean update(Bonus w) throws SQLException {
    	Integer workerRefId = w.getWorkerRefId();
        Integer amount = w.getBonusAmount();
        Date date = w.getBonusDate();
        String query = String.format("UPDATE Bonus SET worker_ref_id = %d, bonus_amount = %d, bonus_date = '%s' WHERE worker_ref_id = %d",
                						 workerRefId,
                						 amount,
                						 date,
                						 workerRefId);
        try (Statement statement = conn.createStatement()) {
            int res = statement.executeUpdate(query);
            System.out.println(res + " row get affected");
            return res == 1;
        }

    }
}
