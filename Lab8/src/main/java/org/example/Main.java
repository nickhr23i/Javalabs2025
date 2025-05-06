package org.example;
import org.Models.*;

import java.sql.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    public static void main(String[] args) {
        try {
            var continents = new ContinentDAO();
            var continent = new Continent();
            continent.setName("Europe");
            continents.create(continent);
            var countries = new CountryDAO();
            Continent europe = continents.findByName("Europe");
            var country = new Country();
            country.setName("Romania");
            country.setCode("ROU");
            country.setContinentId(europe.getId());
            countries.create(country);
            country.setName("Ukraine");
            country.setCode("UKR");
            country.setContinentId(europe.getId());
            countries.create(country);
            List<Country> countryList=countries.findAll();
            for(Country c:countryList){
                if(c.getContinentId()==europe.getId()){
                    System.out.println(c.getName());
                }
            }
            var cities = new CityDAO();
            int id1,id2;
            City city1 = new City();
            City city2 = new City();
            for(int i=0;i<15;i++){
                id1=(int)(Math.random()*10000)%245+1;
                id2=(int)(Math.random()*10000)%245+1;
                city1=cities.findById(id1);
                city2=cities.findById(id2);
                System.out.println("The distance between "+city1.getName()+" and "+city2.getName()+" is: ");
                System.out.println(distance(city1.getLatitude(),city2.getLatitude(),city1.getLongitude(),city2.getLongitude())+"km");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}