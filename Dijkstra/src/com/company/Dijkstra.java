package com.company;


import java.util.*;

public class Dijkstra {

    //List<Edge> edges=new ArrayList<Edge>();
    PriorityQueue<City> cityPriorityQueue = new PriorityQueue<City>();
    Map<City, List<Edge>> adjacencyList = new HashMap<>();
    City sourceCityReference;

    public Dijkstra(Set<Edge> edges) {
        for (Edge e : edges) {
            addToAdjList(e.getOriginCity(), e);
        }
    }

    public void findShortestPathFrom(City sourceCity) {
        this.sourceCityReference = sourceCity;
        sourceCity.setTotalWeight(0);
        cityPriorityQueue.add(sourceCity);

        while (cityPriorityQueue.size() > 0) {
            City src = cityPriorityQueue.poll();
            List<Edge> edges = adjacencyList.get(src);

            if (edges != null) {
                for (Edge e : edges) {
                    if ((src.getTotalWeight() + e.getWeight()) < e.getDestCity().getTotalWeight()) {
                        e.getDestCity().setTotalWeight(src.getTotalWeight() + e.getWeight());
                        e.getDestCity().setParent(src);
                        cityPriorityQueue.add(e.getDestCity());
                    }
                }

            }


        }

    }

    public void printShortestPathTo(City destCity) {
        ArrayList<City> path = new ArrayList<>();
        City traverseCity = destCity;
        while (traverseCity.getParent() != null) {
            traverseCity = traverseCity.getParent();
            path.add(traverseCity);
        }

        Collections.reverse(path);
        System.out.println("Path from " + sourceCityReference.getName());
        for (City c : path) {
            System.out.println(c.getName() + " distance from source " + c.getTotalWeight());
        }

        System.out.println("Total distance to destination " + destCity + ": " + destCity.getTotalWeight());

    }

    private void addToAdjList(City src, Edge edge) {
        if (adjacencyList.get(src) == null) {
            List<Edge> destinations = new ArrayList<>();
            destinations.add(edge);
            adjacencyList.put(src, destinations);
        } else {
            adjacencyList.get(src).add(edge);
        }

    }

}
