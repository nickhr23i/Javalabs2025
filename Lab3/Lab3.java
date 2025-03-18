
import java.time.LocalTime;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Nico
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aircraft airliner = new Airliner("Alpha1");
        Aircraft freighter = new Freighter("Fox5", 120.7);
        Aircraft drone = new Drone("Hawk3", 8.5);
        Aircraft airliner2 = new Airliner("Alps");
        Aircraft airliner3 = new Airliner("AFOne");

        CargoCapable[] cargo = new CargoCapable[3];
        cargo[0] = new Airliner("D1");
        cargo[1] = new Freighter("F5");
        cargo[2] = new Freighter("F3");

        System.out.println(airliner.getName());
        System.out.println(freighter.getName());
        System.out.println(drone.getName());
        System.out.println(airliner2.getName());
        System.out.println(airliner3.getName());

        List<String> runways = new ArrayList<>();
        runways.add("R1");
        runways.add("R2");
        runways.add("R3");
        Airport airport = new Airport(runways);
        Flight f1 = new Flight(airliner, "123", LocalTime.parse("06:45:12"), LocalTime.parse("06:59:17"));
        Flight f2 = new Flight(freighter, "137", LocalTime.parse("06:57:12"), LocalTime.parse("07:59:17"));
        Flight f3 = new Flight(drone, "129", LocalTime.parse("07:45:12"), LocalTime.parse("08:12:13"));
        Flight f4 = new Flight(airliner2, "157", LocalTime.parse("08:01:12"), LocalTime.parse("08:29:15"));
        Flight f5 = new Flight(airliner3, "193", LocalTime.parse("08:10:12"), LocalTime.parse("09:09:12"));
        Set<Flight> flights = new HashSet<>();
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);
        Problem prob = new Problem(airport, flights);
        Schedule schedule = new Schedule(prob);
        schedule.solve();
        // TODO code application logic here
    }

}
