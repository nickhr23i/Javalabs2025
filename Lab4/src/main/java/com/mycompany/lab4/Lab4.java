/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;

/**
 *
 * @author Nico
 */
public class Lab4 {

    public static void main(String[] args) {
        Location[] locations = new Location[5];
        Faker faker = new Faker();

        locations[0] = new Location(faker.address().streetAddress(), LocationType.FRIENDLY);
        locations[1] = new Location(faker.address().streetAddress(), LocationType.NEUTRAL);
        locations[2] = new Location(faker.address().streetAddress(), LocationType.ENEMY);
        locations[3] = new Location(faker.address().streetAddress(), LocationType.FRIENDLY);
        locations[4] = new Location(faker.address().streetAddress(), LocationType.ENEMY);
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

        int start = 0;
        Graph g = GraphBuilder.empty().buildGraph();
        for (int i = 0; i < locations.length; i++) {
            g.addLabeledVertex(i, locations[i]);
        }
        g.addEdge(0, 1);
        g.setEdgeWeight(0, 1, 15.2);
        g.addEdge(0, 2);
        g.setEdgeWeight(0, 2, 27);
        g.addEdge(1, 4);
        g.setEdgeWeight(1, 4, 19.7);
        g.addEdge(2, 4);
        g.setEdgeWeight(2, 4, 35);
        g.addEdge(4, 3);
        g.setEdgeWeight(4, 3, 11.3);
        g.addEdge(1, 2);
        g.setEdgeWeight(1, 2, 9.5);
        double[] time = new double[locations.length];
        boolean[] marked = new boolean[locations.length];
        int vertex = 0, nrMarked = 1;
        double mini;
        marked[start] = true;
        time[start] = 0;
        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                time[i] = g.getEdgeWeight(start, i);
                marked[i] = false;
            }
        }
        while (nrMarked < locations.length) {
            mini = 1000000;
            for (int i = 0; i < locations.length; i++) {
                if (time[i] < mini && marked[i] == false) {
                    mini = time[i];
                    vertex = i;
                }
            }
            marked[vertex] = true;
            nrMarked++;
            for (int i = 0; i < locations.length; i++) {
                if (marked[i] == false) {
                    if (time[i] > time[vertex] + g.getEdgeWeight(vertex, i)) {
                        time[i] = time[vertex] + g.getEdgeWeight(vertex, i);
                    }
                }
            }
        }
        List<Location> friendlyLocs, neutralLocs, enemyLocs;
        friendlyLocs = Arrays.stream(locations).filter(loc -> loc.getlType() == LocationType.FRIENDLY)
                .collect(Collectors.toCollection(ArrayList::new));
        neutralLocs = Arrays.stream(locations).filter(loc -> loc.getlType() == LocationType.NEUTRAL)
                .collect(Collectors.toCollection(ArrayList::new));
        enemyLocs = Arrays.stream(locations).filter(loc -> loc.getlType() == LocationType.ENEMY)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Start location is: " + locations[start].getName());
        System.out.println("Direct times between locations:");
        for (int i = 0; i < locations.length - 1; i++) {
            for (int j = i + 1; j < locations.length; j++) {
                System.out.println(locations[i].getName() + "  " + locations[j].getName() + " : " + g.getEdgeWeight(i, j));
            }
        }
        System.out.println("Shortest time from start to each friendly location");
        for (Location l : friendlyLocs) {
            for (int i = 0; i < locations.length; i++) {
                if (l.compareTo(g.getVertexLabel(i)) == 0) {
                    System.out.println(l.getName() + " : " + time[i]);
                }
            }
        }
        System.out.println("Shortest time from start to each neutral location");
        for (Location l : neutralLocs) {
            for (int i = 0; i < locations.length; i++) {
                if (l.compareTo(g.getVertexLabel(i)) == 0) {
                    System.out.println(l.getName() + " : " + time[i]);
                }
            }
        }
        System.out.println("Shortest time from start to each enemy location");
        for (Location l : enemyLocs) {
            for (int i = 0; i < locations.length; i++) {
                if (l.compareTo(g.getVertexLabel(i)) == 0) {
                    System.out.println(l.getName() + " : " + time[i]);
                }
            }
        }
    }
}
