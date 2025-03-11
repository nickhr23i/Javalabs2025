/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Freighter extends Aircraft implements CargoCapable {

    private double maximumPayload;

    public Freighter(String name) {
        this.name = name;
    }

    public Freighter(String name, double maximumPayload) {
        this.name = name;
        this.maximumPayload = maximumPayload;
    }

    @Override
    public double getMaximumPayload() {
        return maximumPayload;
    }

    public void setMaximumPayload(double maximumPayload) {
        this.maximumPayload = maximumPayload;
    }
}
