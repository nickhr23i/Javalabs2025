
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Airport {
    private List<String>runways=new ArrayList<>();
    
    public Airport(List<String> runways){
        this.runways=runways;
    }

    /**
     * @return the runways
     */
    public List<String> getRunways() {
        return runways;
    }

    /**
     * @param runways the runways to set
     */
    public void setRunways(List<String> runways) {
        this.runways = runways;
    }
}
