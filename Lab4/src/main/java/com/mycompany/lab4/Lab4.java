/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.*;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;

/**
 *
 * @author Nico
 */
public class Lab4 {

    public class Data {

        public int nrFriendly, nrEnemy, nrNeutral;
        public double safetyPercentage;
    }

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

        g.setEdgeWeight(0, 1, 0.87);
        g.setEdgeWeight(0, 2, 0.27);
        g.setEdgeWeight(1, 4, 0.17);
        g.setEdgeWeight(2, 4, 0.05);
        g.setEdgeWeight(4, 3, 0.63);
        g.setEdgeWeight(1, 2, 0.49);

        Lab4 lab4 = new Lab4();
        lab4.safestRoute(g, locations.length);

        Graph gRand = GraphBuilder.empty().buildGraph();
        LocationType[] type = new LocationType[3];
        type[0] = LocationType.FRIENDLY;
        type[1] = LocationType.NEUTRAL;
        type[2] = LocationType.ENEMY;
        Location[] locs = new Location[200];
        for (int i = 0; i < locs.length; i++) {
            locs[i] = new Location(faker.address().streetAddress(), type[(int) (Math.random() * 10000) % 3]);
        }
        for (int i = 0; i < locs.length; i++) {
            gRand.addLabeledVertex(i, locs[i]);
        }
        for (int i = 0; i < locs.length; i++) {
            for (int j = 0; j < locs.length; j++) {
                if (i != j) {
                    if ((int) (Math.random() * 10000) % 100 > 50) {
                        gRand.addEdge(i, j);
                        gRand.setEdgeWeight(i, j, Math.random());
                    }
                }
            }
        }
        lab4.safestRoute(gRand, locs.length);
    }

    void safestRoute(Graph g, int size) {

        Data[][] data = new Data[size][size];
        Location loc;
        LocationType type;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = new Data();
                data[i][j].nrFriendly = data[i][j].nrEnemy = data[i][j].nrNeutral = 0;
                data[i][j].safetyPercentage = 0;
                loc = (Location) g.getVertexLabel(i);
                type = loc.getlType();
                if (null == type) {
                    return;
                } else {
                    switch (type) {
                        case FRIENDLY ->
                            data[i][j].nrFriendly++;
                        case NEUTRAL ->
                            data[i][j].nrNeutral++;
                        default ->
                            data[i][j].nrEnemy++;
                    }
                }
                if (i == j) {
                    data[i][j].safetyPercentage = 1;
                } else {
                    if (g.getEdgeWeight(i, j) < 1) {
                        data[i][j].safetyPercentage = g.getEdgeWeight(i, j);
                    }
                    loc = (Location) g.getVertexLabel(j);
                    type = loc.getlType();
                    if (null == type) {
                        return;
                    } else {
                        switch (type) {
                            case FRIENDLY ->
                                data[i][j].nrFriendly++;
                            case NEUTRAL ->
                                data[i][j].nrNeutral++;
                            default ->
                                data[i][j].nrEnemy++;
                        }
                    }
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (data[i][j].safetyPercentage < data[i][k].safetyPercentage * data[k][j].safetyPercentage) {
                        data[i][j].safetyPercentage = data[i][k].safetyPercentage * data[k][j].safetyPercentage;
                        data[i][j].nrFriendly = data[i][k].nrFriendly + data[k][j].nrFriendly - data[k][k].nrFriendly;
                        data[i][j].nrNeutral = data[i][k].nrNeutral + data[k][j].nrNeutral - data[k][k].nrNeutral;
                        data[i][j].nrEnemy = data[i][k].nrEnemy + data[k][j].nrEnemy - data[k][k].nrEnemy;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Prob of getting from " + i + " to " + j + " on the safest path: " + data[i][j].safetyPercentage);
                System.out.println("Nr of friendly locations the path passes through " + data[i][j].nrFriendly);
                System.out.println("Nr of neutral locations the path passes through " + data[i][j].nrNeutral);
                System.out.println("Nr of enemy locations the path passes through " + data[i][j].nrEnemy);
            }
        }
        double maxSafety, minSafety, avgSafety;
        List<Data> locationData;
        for (int i = 0; i < size; i++) {
            locationData = Arrays.stream(data[i]).filter(d -> (d.safetyPercentage > 0 && d.safetyPercentage < 1)).collect(Collectors.toCollection(ArrayList::new));
            maxSafety = locationData.stream().mapToDouble(d -> d.safetyPercentage).max().getAsDouble();
            minSafety = locationData.stream().mapToDouble(d -> d.safetyPercentage).min().getAsDouble();
            avgSafety = locationData.stream().mapToDouble(d -> d.safetyPercentage).average().getAsDouble();
            System.out.println("Maximum safety of a path leaving from " + i + " to another location " + maxSafety);
            System.out.println("Minimum safety of a path leaving from " + i + " to another location " + minSafety);
            System.out.println("Average safety of a path leaving from " + i + " to another location " + avgSafety);
        }
    }

}
