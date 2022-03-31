package com.workers.jdbcexample.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.workers.jdbcexample.dao.WorkerDAO;
import com.workers.jdbcexample.model.Worker;
import com.workers.jdbcexample.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO{
    Connection conn;
    public WorkerRepository() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }
    @Override
    public void create(Worker w) throws SQLException {
        int workerId = w.getWorkerId();
        String firstName = w.getFirstName();
        String lastName = w.getLastName();
        int salary = w.getSalary();
        Date date = w.getJoiningDate();
        String department = w.getDepartment();
        String email = w.getEmail();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String joiningDate = sdf.format(date);
        String sql = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s');", 
                workerId,
                firstName,
                lastName, 
                salary, 
                joiningDate, 
                department, 
                email);
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
        }

    }
    @Override
    public void delete(Integer workerId) throws SQLException {
        String sql = "DELETE FROM Worker WHERE WORKER_ID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, workerId);
            int res = ps.executeUpdate();
            System.out.println(res + " row/s affected.");
        }

    }

    @Override
    public Worker getWorkerById(Integer workerId) throws SQLException {
        String sql = "SELECT worker_id,first_name,last_name,salary,joining_date,department,email FROM worker WHERE worker_id = ?";
        Worker wkr = null;
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, workerId);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                wkr = new Worker(r.getInt("worker_id"),r.getString("first_name"), r.getString("last_name"), r.getInt("salary"), r.getDate("joining_date"),r.getString("department"), r.getString("email"));
            }
        }
        return wkr;
    }

    @Override
    public List<Worker> getAllWorkers() throws SQLException {
         String sql = "SELECT worker_id,first_name,last_name,salary,joining_date,department,email FROM worker";
         try(Statement st = conn.createStatement()){
         List<Worker> wkr = new ArrayList<>();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
             wkr.add(new Worker(rs.getInt("worker_id"),rs.getString("first_name"),rs.getString("last_name"),
             rs.getInt("salary"),rs.getDate("joining_date"),rs.getString("department"),rs.getString("email")));
         }
         return wkr;
        }
    }

    @Override
    public void update(Worker w) throws SQLException {
        int workerId = w.getWorkerId();
        String firstName = w.getFirstName();
        String lastName = w.getLastName();
        int salary = w.getSalary();
        Date date = w.getJoiningDate();
        String department = w.getDepartment();
        String email = w.getEmail();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(date);
        String query = String.format("""
                UPDATE worker SET worker_id =%d, first_name = '%s', last_name ='%s', salary =%d, joining_date = '%s', department = '%s',
                email = '%s' WHERE worker_id = %d """,
                workerId,
                firstName,
                lastName, 
                salary, 
                joiningDate, 
                department, 
                email, 
                workerId);
        try (Statement statement = conn.createStatement()) {
            int res = statement.executeUpdate(query);
            System.out.println(res + " row get affected");
        }

    }
}
