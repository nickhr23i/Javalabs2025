/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Airliner extends Aircraft implements PassengerCapable, CargoCapable {

    private int seatCount;
    private double maximumPayload;

    public Airliner(String name) {
        this.name = name;
    }

    public Airliner(String name, int seatCount, double maximumPayload) {
        this.name = name;
        this.seatCount = seatCount;
        this.maximumPayload = maximumPayload;
    }

    @Override
    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public double getMaximumPayload() {
        return maximumPayload;
    }

    public void setMaximumPayload(double maximumPayload) {
        this.maximumPayload = maximumPayload;
    }

}
