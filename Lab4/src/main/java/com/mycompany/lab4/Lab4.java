/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Nico
 */
public class Lab4 {

    public static void main(String[] args) {
        Location[] locations = new Location[5];
        locations[0] = new Location("l1", LocationType.FRIENDLY);
        locations[1] = new Location("l2", LocationType.NEUTRAL);
        locations[2] = new Location("l9", LocationType.ENEMY);
        locations[3] = new Location("l3", LocationType.FRIENDLY);
        locations[4] = new Location("l5", LocationType.ENEMY);
        Set<Location> friendlies;
        List<Location> enemies;
        friendlies = Arrays.stream(locations).filter(loc -> loc.getlType() == LocationType.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));
        enemies = Arrays.stream(locations).filter(loc -> loc.getlType() == LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getlType)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));
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
