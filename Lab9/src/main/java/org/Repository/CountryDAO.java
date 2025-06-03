package org.Repository;

import org.Model.Country;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements AbstractCountry {
    ContinentDAO continentDAO = new ContinentDAO();

    public void create(Country country) {
        try (Connection con = Database.getConnection(); PreparedStatement pstmt = con.prepareStatement("insert into countries (name,code,continent) values (?,?,?)")) {
            pstmt.setString(1, country.getName());
            pstmt.setString(2, country.getCode());
            pstmt.setInt(3, country.getContinent().getId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create country" + country.getName());
        }

    }

    public List<Country> findByName(String name) {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from countries where name='" + name + "'")) {
            List<Country> countries = new ArrayList<>();
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(name);
                country.setCode(rs.getString("code"));
                country.setContinent(continentDAO.findById(rs.getInt("continent")));
                countries.add(country);
            }
            if (!countries.isEmpty()) {
                return countries;
            } else return null;
        } catch (SQLException e) {
            System.err.println("Failed to get countries" + e.getMessage());
            return null;
        }
    }

    public Country findById(Integer id) {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where id=" + id)) {
            if (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setContinent(continentDAO.findById(rs.getInt("continent")));
                return country;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Failed to get countries" + e.getMessage());
            return null;
        }
    }

}
