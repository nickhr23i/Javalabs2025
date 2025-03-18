
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Problem {
    private Airport airport;
    private Set<Flight> flights=new HashSet<>();
    
    public Problem(Airport airport,Set<Flight> flights){
        this.airport=airport;
        this.flights=flights;
    }

    /**
     * @return the airport
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     * @param airport the airport to set
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    /**
     * @return the flights
     */
    public Set<Flight> getFlights() {
        return flights;
    }

    /**
     * @param flights the flights to set
     */
    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
