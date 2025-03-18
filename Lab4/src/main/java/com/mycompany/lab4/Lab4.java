/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import java.util.*;

/**
 *
 * @author Nico
 */
public class Lab4 {

    public static void main(String[] args) {
        Location[] locations = new Location[5];
        locations[0] = new Location("l1", LocationType.FRIENDLY);
        locations[1] = new Location("l2", LocationType.NEUTRAL);
        locations[2] = new Location("l4", LocationType.FRIENDLY);
        locations[3] = new Location("l3", LocationType.FRIENDLY);
        locations[4] = new Location("l5", LocationType.ENEMY);
        Set<Location> friendlies = new TreeSet<>();
        List<Location> enemies = new LinkedList<>();
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].getlType() == LocationType.FRIENDLY) {
                friendlies.add(locations[i]);
            }
            if (locations[i].getlType() == LocationType.ENEMY) {
                enemies.add(locations[i]);
            }
        }
        System.out.println("Friendlies: ");
        for (Location l : friendlies) {
            System.out.println(l.getName());
        }
        System.out.println("Enemies: ");
        for (Location l : enemies) {
            System.out.println(l.getName());
        }

    }
}
