/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author Nico
 */
public class Location implements Comparable{
    private String name;
    private LocationType lType;

    public Location(String name,LocationType lType){
        this.name=name;
        this.lType=lType;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lType
     */
    public LocationType getlType() {
        return lType;
    }

    /**
     * @param lType the lType to set
     */
    public void setlType(LocationType lType) {
        this.lType = lType;
    }

    @Override
    public int compareTo(Object o) {
        if(o==null){
            throw new NullPointerException();
        }
        Location l=(Location) o;
        return(name.compareTo(l.getName())); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
