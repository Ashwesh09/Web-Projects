package com.springboot.my.org.crudapi.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.TitleDAO;
import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.util.DatabaseConnection;

@Repository
public class TitleRepository implements TitleDAO{
    Connection conn;
    public TitleRepository() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }
    @Override
    public Boolean create(Title w) throws SQLException {
        Integer workerRefId = w.getWorkerRefId();
        String title	 = w.getWorkerTitle();
        Date date = w.getAffectedFrom();
        String sql = String.format("INSERT INTO Title VALUES(%d,'%s','%s');", 
        		workerRefId,
        		title,
        		date);
        try (Statement statement = conn.createStatement()) {
            return statement.executeUpdate(sql) == 1;
        }

    }
    @Override
    public Boolean delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Title WHERE worker_ref_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            System.out.println(res + " row/s affected.");
            return res == 1;
        }

    }

    @Override
    public Title getTitleById(Integer id) throws SQLException {
        String sql = "SELECT worker_ref_id,worker_title, affected_from FROM Title WHERE worker_ref_id = ?";
        Title wkr = null;
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                wkr = new Title(r.getInt("worker_ref_id"),r.getString("worker_title"),r.getDate("affected_from"));
            }
        }
        return wkr;
    }

    @Override
    public List<Title> getAllTitles() throws SQLException {
         String sql = "SELECT worker_ref_id,worker_title, affected_from FROM Title";
         try(Statement st = conn.createStatement()){
         List<Title> wkr = new ArrayList<>();
         ResultSet r = st.executeQuery(sql);
         while(r.next()) {
             wkr.add(new Title(r.getInt("worker_ref_id"),r.getString("worker_title"),r.getDate("affected_from")));
         }
         return wkr;
        }
    }

    @Override
    public Boolean update(Title w) throws SQLException {
    	Integer workerRefId = w.getWorkerRefId();
        String title	 = w.getWorkerTitle();
        Date date = w.getAffectedFrom();
        String query = String.format("""
                UPDATE title SET worker_ref_id =%d, worker_title = '%s', affected_from = '%s' 
                WHERE worker_ref_id = %d""",
                workerRefId,
                title,
                date,
                workerRefId);
        try (Statement statement = conn.createStatement()) {
            int res = statement.executeUpdate(query);
            System.out.println(res + " row get affected");
            return res == 1;
        }catch(SQLException e){
        	return false;
        }

    }
}
