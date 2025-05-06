package org.example;

import org.Models.Continent;
import org.Models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public void create(Country country) throws SQLException {
        try (Connection con = Database.getConnection(); PreparedStatement pstmt = con.prepareStatement("insert into countries (name,code,continent) values (?,?,?)")) {
            pstmt.setString(1, country.getName());
            pstmt.setString(2, country.getCode());
            pstmt.setInt(3, country.getContinentId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create country" + country.getName());
        }

    }

    public Country findByName(String name) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from countries where name='" + name + "'")) {
            if (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(name);
                country.setCode(rs.getString("code"));
                country.setContinentId(rs.getInt("continent"));
                return country;
            } else {
                return null;
            }
        }
    }

    public Country findById(int id) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where id=" + id)) {
            if (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setContinentId(rs.getInt("continent"));
                return country;
            } else {
                return null;
            }
        }
    }

    public List<Country> findAll() throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from countries")) {
            List<Country> countries = new ArrayList<>();
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setContinentId(rs.getInt("continent"));
                countries.add(country);
            }
            if (!countries.isEmpty()) {
                return countries;
            } else return null;
        }
    }
}
