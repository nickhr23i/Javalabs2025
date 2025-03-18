
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nico
 */
public class Schedule {

    private Problem problem;
    private Map<Flight, String> flightMap = new HashMap<>();

    public Schedule(Problem problem) {
        this.problem = problem;
    }

    /**
     * @return the flightMap
     */
    public Map<Flight, String> getFlightMap() {
        return flightMap;
    }

    /**
     * @param flightMap the flightMap to set
     */
    public void setFlightMap(Map<Flight, String> flightMap) {
        this.flightMap = flightMap;
    }

    /**
     * @return the problem
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void solve() {
        Set<Flight> flights = problem.getFlights();
        List<Flight> flightsList = new ArrayList<>();

        for (Flight f : flights) {
            flightsList.add(f);
        }
        String start1, start2, end2;
        List<String> freeRunways;
        //Arrays.sort(flightsList);
        for (Flight f1 : flightsList) {
            freeRunways = problem.getAirport().getRunways();
            if (flightMap.containsKey(f1) == false) {
                for (Flight f2 : flightMap.keySet()) {
                    start1 = f1.getInterval().getFirst().toString();
                    start2 = f2.getInterval().getFirst().toString();
                    end2 = f2.getInterval().getSecond().toString();
                    if (start1.compareTo(start2) > 0 && start1.compareTo(end2) < 0) {
                        freeRunways.remove(flightMap.get(f2));
                    }
                }
                if(freeRunways.size()>0){
                    flightMap.put(f1, freeRunways.get(0));
                }
            }
            System.out.println(f1.getIdNumber()+" : "+flightMap.get(f1));
        }
    }
}
