package com.company;

import java.io.Console;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        City boston = new City("Boston");
        City nyc = new City("NewYork");
        City washington = new City("Washington");
        City sfc = new City("SanFrancisco");
        City sanDiego = new City("SanDiego");
        City dallas = new City("Dallas");
        City chicago = new City("Chicago");
        City phoenix = new City("Phoenix");

        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(boston, nyc, 190));
        edges.add(new Edge(boston, washington, 394));
        edges.add(new Edge(boston, sfc, 2696));
        edges.add(new Edge(boston, sanDiego, 2582));
        edges.add(new Edge(boston, dallas, 1551));
        edges.add(new Edge(boston, chicago, 850));
        edges.add(new Edge(boston, phoenix, 2298));

        edges.add(new Edge(nyc, boston, 190));
        edges.add(new Edge(nyc, washington, 200));
        edges.add(new Edge(nyc, sfc, 2569));
        edges.add(new Edge(nyc, sanDiego, 2431));
        edges.add(new Edge(nyc, dallas, 1372));
        edges.add(new Edge(nyc, chicago, 712));
        edges.add(new Edge(nyc, phoenix, 2142));

        edges.add(new Edge(washington, nyc, 200));
        edges.add(new Edge(washington, boston, 394));
        edges.add(new Edge(washington, sfc, 2438));
        edges.add(new Edge(washington, sanDiego, 2272));
        edges.add(new Edge(washington, dallas, 1183));
        edges.add(new Edge(washington, chicago, 594));
        edges.add(new Edge(washington, phoenix, 1980));

        edges.add(new Edge(sfc, nyc, 2569));
        edges.add(new Edge(sfc, washington, 2438));
        edges.add(new Edge(sfc, boston, 2696));
        edges.add(new Edge(sfc, sanDiego, 459));
        edges.add(new Edge(sfc, dallas, 1483));
        edges.add(new Edge(sfc, chicago, 1857));
        edges.add(new Edge(sfc, phoenix, 654));

        edges.add(new Edge(sanDiego, nyc, 2431));
        edges.add(new Edge(sanDiego, washington, 2272));
        edges.add(new Edge(sanDiego, sfc, 459));
        edges.add(new Edge(sanDiego, boston, 2582));
        edges.add(new Edge(sanDiego, dallas, 1183));
        edges.add(new Edge(sanDiego, chicago, 1733));
        edges.add(new Edge(sanDiego, phoenix, 299));

        edges.add(new Edge(dallas, nyc, 1372));
        edges.add(new Edge(dallas, washington, 1183));
        edges.add(new Edge(dallas, sfc, 1483));
        edges.add(new Edge(dallas, sanDiego, 1183));
        edges.add(new Edge(dallas, boston, 1551));
        edges.add(new Edge(dallas, chicago, 806));
        edges.add(new Edge(dallas, phoenix, 886));

        edges.add(new Edge(chicago, nyc, 712));
        edges.add(new Edge(chicago, washington, 594));
        edges.add(new Edge(chicago, sfc, 1857));
        edges.add(new Edge(chicago, sanDiego, 1733));
        edges.add(new Edge(chicago, dallas, 806));
        edges.add(new Edge(chicago, boston, 850));
        edges.add(new Edge(chicago, phoenix, 1453));


        edges.add(new Edge(phoenix, nyc, 2142));
        edges.add(new Edge(phoenix, washington, 1980));
        edges.add(new Edge(phoenix, sfc, 654));
        edges.add(new Edge(phoenix, sanDiego, 299));
        edges.add(new Edge(phoenix, dallas, 886));
        edges.add(new Edge(phoenix, chicago, 1453));
        edges.add(new Edge(phoenix, boston, 2298));

        CityGraph cityGraph = new CityGraph(edges);

        HashMap<City, List<City>> connectedCities = cityGraph.getCityAdjList();
        printConnections(connectedCities);
    }

    private static void printConnections(HashMap<City, List<City>> connectedCities) {
        for (City city : connectedCities.keySet()) {
            System.out.println("-----------------------");
            System.out.println("Source: " + city);
            for (City destCity : connectedCities.get(city)) {
                System.out.println("    Destination: " + destCity);
            }

        }

    }
}