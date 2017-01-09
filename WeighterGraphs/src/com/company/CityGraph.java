package com.company;

import java.util.*;

/**
 * Created by Home on 1/3/2017.
 */
public class CityGraph {
    private List<Edge> edges;
    private HashMap<City, List<City>> cityAdjList;
    private Set<City> cities = new HashSet<City>();
    private int totalCities = 0;
    private int expectedEdges;
    private int actualEdges = 0;

    public CityGraph(Set<Edge> edges) {
        this.edges = new ArrayList<Edge>();
        for (Edge edge : edges) {
            this.edges.add(edge);
            this.cities.add(edge.getOriginCity());
            this.cities.add(edge.getDestCity());
        }
        totalCities = this.cities.size();
        expectedEdges = totalCities - 1;
        Collections.sort(this.edges);
        cityAdjList = new HashMap<City, List<City>>();
    }

    public HashMap<City, List<City>> getCityAdjList() {
        if (this.edges != null) {
            for (Edge edge : this.edges) {
                if (actualEdges < expectedEdges) {
                    City origin = edge.getOriginCity();
                    City dest = edge.getDestCity();
                    if (bfsIsReachable(origin, dest) == false) {
                        addEdgeToAdjList(origin, dest);
                    }
                    resetVisited();
                }
                else
                {
                    break;
                }

            }
        }

        return cityAdjList;
    }

    private void addEdgeToAdjList(City origin, City dest) {
        if (cityAdjList.containsKey(origin) == false) {
            cityAdjList.put(origin, new ArrayList<City>());
        }
        cityAdjList.get(origin).add(dest);
        actualEdges++;
    }

    private boolean bfsIsReachable(City origin, City dest) {

        return isReachableBfs(origin, dest);

    }

    private boolean isReachableBfs(City city, City finalDest) {

        LinkedList<City> cityQueue = new LinkedList<City>();
        city.visit(null);
        cityQueue.add(city);
        while (cityQueue.isEmpty() == false) {
            City parentCity = cityQueue.removeFirst();
            List<City> destinations = cityAdjList.get(parentCity);
            if (destinations != null) {
                for (City dest : destinations) {
                    if (dest.equals(finalDest)) {
                        return true;
                    }
                    if (dest.isVisited() == false) {
                        dest.visit(parentCity);
                        cityQueue.add(dest);
                    }
                }
            }

        }

        return false;
    }

    private void resetVisited() {
        for (City city : cities) {
            city.setVisited(false);
        }
    }




}
