package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/vehicle_sale_system";
    private static final String USER = "root";
    private static final String PASSWORD = "lasan2002";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (name, brand, model, price, color, registration_number, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); 
        	PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, vehicle.getName());
            pstmt.setString(2, vehicle.getBrand());
            pstmt.setString(3, vehicle.getModel());
            pstmt.setDouble(4, vehicle.getPrice());
            pstmt.setString(5, vehicle.getColor());
            pstmt.setString(6, vehicle.getRegistrationNumber());
            pstmt.setString(7, vehicle.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setName(rs.getString("name"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setPrice(rs.getDouble("price"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setDescription(rs.getString("description"));
                vehicles.add(vehicle);
            }
            System.out.println("Number of vehicles fetched: " + vehicles.size()); // Debug log
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public Vehicle getVehicleById(int id) {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setName(rs.getString("name"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setPrice(rs.getDouble("price"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET name = ?, brand = ?, model = ?, price = ?, color = ?, registration_number = ?, description = ? WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, vehicle.getName());
            pstmt.setString(2, vehicle.getBrand());
            pstmt.setString(3, vehicle.getModel());
            pstmt.setDouble(4, vehicle.getPrice());
            pstmt.setString(5, vehicle.getColor());
            pstmt.setString(6, vehicle.getRegistrationNumber());
            pstmt.setString(7, vehicle.getDescription());
            pstmt.setInt(8, vehicle.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}