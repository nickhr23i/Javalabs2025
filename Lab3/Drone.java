/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Drone extends Aircraft {

    private double batteryLife;

    public Drone(String name) {
        this.name = name;
    }

    public Drone(String name, double batteryLife) {
        this.name = name;
        this.batteryLife = batteryLife;
    }

    /**
     * @return the batteryLife
     */
    public double getBatteryLife() {
        return batteryLife;
    }

    /**
     * @param batteryLife the batteryLife to set
     */
    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

}
