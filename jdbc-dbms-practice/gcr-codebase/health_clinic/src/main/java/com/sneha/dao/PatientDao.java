package com.sneha.dao;

import com.sneha.config.DBConnection;
import com.sneha.model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDao {

  public boolean existsByPhoneOrEmail(String phone, String email) throws SQLException {
    String sql = "SELECT id FROM patients WHERE phone = ? OR email = ?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, phone);
      ps.setString(2, email);

      ResultSet rs = ps.executeQuery();
      return rs.next(); // true if any record found
    }
  }

  public void insert(Patient p) throws SQLException {
    String sql = "INSERT INTO patients (name, dob, phone, email, address, blood_group) " +
        "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, p.getName());
      ps.setDate(2, Date.valueOf(p.getDob()));
      ps.setString(3, p.getPhone());
      ps.setString(4, p.getEmail());
      ps.setString(5, p.getAddress());
      ps.setString(6, p.getBloodGroup());

      ps.executeUpdate();
    }
  }

  public void update(Patient p) throws SQLException {
    String sql = "UPDATE patients SET name=?, dob=?, phone=?, email=?, address=?, blood_group=? WHERE id=?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, p.getName());
      ps.setDate(2, Date.valueOf(p.getDob()));
      ps.setString(3, p.getPhone());
      ps.setString(4, p.getEmail());
      ps.setString(5, p.getAddress());
      ps.setString(6, p.getBloodGroup());
      ps.setInt(7, p.getId());

      ps.executeUpdate();
    }
  }

  public List<Patient> searchByName(String name) throws SQLException {
    String sql = "SELECT * FROM patients WHERE name LIKE ?";
    List<Patient> list = new ArrayList<>();

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, "%" + name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String patientName = rs.getString("name");
        Date dob = rs.getDate("dob");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String address = rs.getString("address");
        String bloodGroup = rs.getString("blood_group");

        Patient p = new Patient(id, patientName, email, dob.toLocalDate(), phone, address, bloodGroup);
        list.add(p);
      }
    }
    return list;
  }

}
