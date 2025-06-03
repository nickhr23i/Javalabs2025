package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ConstraintSolver.CitySelection;
import org.ConstraintSolver.CitySolution;
import org.Model.City;
import org.Model.Continent;
import org.Repository.*;
import org.optaplanner.core.api.solver.*;
import org.optaplanner.core.api.solver.SolverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String type = "none";
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("configuration.properties"));

            type = props.getProperty("daoType");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        AbstractFactory factory = AbstractFactory.getFactory(type);
        AbstractContinent cr = factory.getContinentDAO();
        AbstractCity city = factory.getCityDAO();
        Continent continent = new Continent("Europe");
        // cr.create(continent);
        List<Continent> continents = cr.findByName("Europe");
        for (Continent c : continents) {
            System.out.println(c.getId() + " " + c.getName());
        }

        List<City> cities = new ArrayList<City>();
        City c;
        for (int i = 2; i <= 246; i++) {
            c = city.findById(i);
            cities.add(c);
        }
        List<CitySelection> selectionList = new ArrayList<>();
        for (int i = 0; i < 2; i++) { // Try selecting 4 cities
            CitySelection selection = new CitySelection();
            selection.setId(i);
            selectionList.add(selection);
        }
        CitySolution problem = new CitySolution();
        problem.setCityList(cities);
        problem.setSelectionList(selectionList);

        SolverFactory<CitySolution> solverFactory =
                SolverFactory.createFromXmlResource("citySolverConfig.xml");
        Solver<CitySolution> solver = solverFactory.buildSolver();
        CitySolution solution = solver.solve(problem);
        selectionList.clear();
        selectionList=solution.getSelectionList();
        System.out.println(solution.getScore());
        for(CitySelection sel : selectionList){
            System.out.println(sel.getCity().getName()+" "+sel.getCity().getPopulation());
        }
        EntityManagerFactorySingleton.closeEntityManagerFactory();
        Database.closeConnection();
    }
}