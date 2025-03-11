/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public abstract class Aircraft {

    protected String model;
    protected String tailNumber;
    protected String name;
    protected double wingSpan;

    /**
     * @return the model
     */
    protected String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    protected void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the tailNumber
     */
    protected String getTailNumber() {
        return tailNumber;
    }

    /**
     * @param tailNumber the tailNumber to set
     */
    protected void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    /**
     * @return the name
     */
    protected String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * @return the wingSpan
     */
    protected double getWingSpan() {
        return wingSpan;
    }

    /**
     * @param wingSpan the wingSpan to set
     */
    protected void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}
