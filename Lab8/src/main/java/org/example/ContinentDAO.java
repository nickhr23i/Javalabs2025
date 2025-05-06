package org.example;

import org.Models.Continent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO {
    public void create(Continent continent) throws SQLException {
        try (Connection con = Database.getConnection(); PreparedStatement pstmt = con.prepareStatement("insert into continents (name) values (?)")) {
            pstmt.setString(1, continent.getName());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create continent " + continent.getName());
        }
    }

    public Continent findByName(String name) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from continents where name='" + name + "'")) {
            if (rs.next()) {
                Continent continent = new Continent();
                continent.setId(rs.getInt("id"));
                continent.setName(name);
                return continent;
            } else {
                return null;
            }
        }
    }

    public Continent findById(int id) throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from continents where id=" + id)) {
            if (rs.next()) {
                Continent continent = new Continent();
                continent.setId(rs.getInt("id"));
                continent.setName(rs.getString("name"));
                return continent;
            } else {
                return null;
            }
        }
    }

    public List<Continent> findAll() throws SQLException {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from continents")) {
            List<Continent> continents = new ArrayList<>();
            while (rs.next()) {
                Continent continent = new Continent();
                continent.setId(rs.getInt("id"));
                continent.setName(rs.getString("name"));
                continents.add(continent);
            }
            if (!continents.isEmpty()) {
                return continents;
            } else {
                return null;
            }

        }
    }
}
