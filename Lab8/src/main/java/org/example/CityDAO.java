package org.example;

import org.Models.City;

import java.sql.*;
import java.util.*;

public class CityDAO {
    public void create(City city) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("insert into cities (country,name,capital,latitude,longitude) values (?,?,?,?,?)")) {
            pstmt.setString(1, city.getCountry());
            pstmt.setString(2, city.getName());
            pstmt.setBoolean(3, city.isCapital());
            pstmt.setDouble(4, city.getLatitude());
            pstmt.setDouble(5, city.getLongitude());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create continent " + city.getName());
        }
    }

    public City findByName(String name) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cities where name='" + name + "'")) {
            if (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountry(rs.getString("country"));
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
                return city;
            } else {
                return null;
            }
        }
    }

    public City findById(int id) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cities where id=" + id)) {
            if (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountry(rs.getString("country"));
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
                return city;
            } else {
                return null;
            }
        }
    }

    public List<City> findAll() throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cities")) {
            List<City> cities = new ArrayList<>();
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountry(rs.getString("country"));
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
                cities.add(city);
            }
            if (!cities.isEmpty()) {
                return cities;
            } else {
                return null;
            }

        }
    }
}
