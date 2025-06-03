package org.Repository;

import org.Model.City;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements AbstractCity {
    CountryDAO countryDAO = new CountryDAO();

    public void create(City city) {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("insert into cities (country,name,capital,latitude,longitude) values (?,?,?,?,?)")) {
            pstmt.setString(1, city.getCountry().getName());
            pstmt.setString(2, city.getName());
            pstmt.setBoolean(3, city.getCapital());
            pstmt.setDouble(4, city.getLatitude());
            pstmt.setDouble(5, city.getLongitude());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create continent " + city.getName());
        }
    }

    public List<City> findByName(String name) {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cities where name='" + name + "'")) {
            List<City> cities = new ArrayList<>();
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountry(countryDAO.findByName(rs.getString("country")).getFirst());
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
        } catch (SQLException e) {
            System.err.println("Failed to find continent " + name);
            return null;
        }
    }

    public City findById(Integer id) {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cities where id=" + id)) {
            if (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountry(countryDAO.findByName(rs.getString("country")).getFirst());
                city.setName(rs.getString("name"));
                city.setCapital(rs.getBoolean("capital"));
                city.setLatitude(rs.getDouble("latitude"));
                city.setLongitude(rs.getDouble("longitude"));
                return city;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Failed to find continent " + id);
            return null;
        }
    }

}
