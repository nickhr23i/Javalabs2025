
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Flight {
    private Aircraft aircraft;
    private String idNumber;
    private Pair<LocalTime,LocalTime> interval;

    public Flight(Aircraft aircraft,String idNumber,LocalTime start, LocalTime end){
        this.aircraft=aircraft;
        this.idNumber=idNumber;
        this.interval=new Pair<>(start,end);
    }
    
    /**
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * @param aircraft the aircraft to set
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the interval
     */
    public Pair<LocalTime,LocalTime> getInterval() {
        return interval;
    }

    /**
     * @param start
     * @param end
     */
    public void setInterval(LocalTime start, LocalTime end) {
        this.interval.setFirst(start);
        this.interval.setSecond(end);
    }
    
    public int compareByStart(Flight other){
        if(other==null){
            throw new NullPointerException();
        }
        String start1,start2;
        start1=this.interval.getFirst().toString();
        start2=other.getInterval().getFirst().toString();
        return(start1.compareTo(start2));
    }
}
