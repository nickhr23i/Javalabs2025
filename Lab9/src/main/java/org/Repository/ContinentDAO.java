package org.Repository;

import org.Model.Continent;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO implements AbstractContinent {
    public void create(Continent continent) {
        try (Connection con = Database.getConnection(); PreparedStatement pstmt = con.prepareStatement("insert into continents (name) values (?)")) {
            pstmt.setString(1, continent.getName());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println("Failed to create continent " + continent.getName());
        }
    }

    public List<Continent> findByName(String name) {
        try (Connection con = Database.getConnection(); Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from continents where name='" + name + "'")) {
            List<Continent> continents = new ArrayList<>();
            while (rs.next()) {
                Continent continent = new Continent();
                continent.setId(rs.getInt("id"));
                continent.setName(name);
                continents.add(continent);
            }
            if (!continents.isEmpty()) {
                return continents;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Failed to create continent " + name);
            return null;
        }
    }

    public Continent findById(Integer id) {
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
        } catch (SQLException e) {
            System.err.println("Failed to find continent " + id);
            return null;
        }
    }

}
