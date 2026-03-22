package com.bridgelabz.repository;

import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.exception.DatabaseException;
import com.bridgelabz.utils.ApplicationConfig;
import com.bridgelabz.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    private final ConnectionPool pool;

    public QuantityMeasurementDatabaseRepository() {
        String url = ApplicationConfig.get("db.url", "jdbc:h2:mem:testdb");
        String user = ApplicationConfig.get("db.user", "sa");
        String password = ApplicationConfig.get("db.password", "");

        pool = new ConnectionPool(5, url, user, password);
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        String sql = "INSERT INTO quantity_measurement(operation, operand1, operand2, result, error) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
        	
        	
        	ps.setString(1, entity.getOperation());
        	ps.setString(2, entity.getQ1() != null ? entity.getQ1().toString() : null);
        	ps.setString(3, entity.getQ2() != null ? entity.getQ2().toString() : null);
        	ps.setDouble(4, entity.getResult());
        	ps.setString(5, entity.getError());
        	
            ps.executeUpdate();
        } catch (Exception e) {
            throw new DatabaseException("DB save failed", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM quantity_measurement";

        try (Connection conn = pool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new QuantityMeasurementEntity(
                        rs.getString("operation") + " | " +
                        rs.getString("operand1") + " | " +
                        rs.getString("operand2") + " | " +
                        rs.getString("result")
                ));
            } 
        } catch (Exception e) { 
            throw new DatabaseException("Fetch failed", e);
        }
        return list;
    }

    @Override
    public void deleteAll() {
        try (Connection conn = pool.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DELETE FROM quantity_measurement");

        } catch (Exception e) {
            throw new DatabaseException("Delete failed", e);
        }
    }

    @Override
    public int getTotalCount() {
        try (Connection conn = pool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM quantity_measurement")) {

            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            throw new DatabaseException("Count failed", e);
        }
    }
    
   
}