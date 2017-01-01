package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightsGraph {

    Map<City, List<City>> adjacencyList;

    public FlightsGraph() {
        adjacencyList = new HashMap<City, List<City>>();
    }

    public void addPath(City originCity, City destCity) {
        List<City> destinations;
        if (adjacencyList.get(originCity) == null) {
            destinations = new ArrayList<City>();
        } else {
            destinations = adjacencyList.get(originCity);
        }
        destinations.add(destCity);
        adjacencyList.put(originCity, destinations);
    }


    public void breadthFirstSearch(City originCity) {
        originCity.visit(null);
        LinkedListQueue<City> queue = new LinkedListQueue<City>();
        queue.addToQueue(originCity);
        while (queue.isEmpty() == false) {
            City parent = queue.dequeue();
            //vist children and enqueue
            List<City> destinations = adjacencyList.get(parent);
            if (destinations != null) {
                for (City child : destinations) {
                    if (child.isVisited() == false) {
                        child.visit(parent);
                        queue.addToQueue(child);
                    }
                }
            }


        }

    }
}