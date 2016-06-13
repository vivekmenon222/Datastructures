package com.company;

import java.util.*;

/**
 * Created by Home on 6/5/2016.
 */
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

    public void depthFirstSearch(City originCity) {
        originCity.visit();
        List<City> destinations = adjacencyList.get(originCity);
        if (destinations != null) {
            for (City destination : destinations) {
                if (!(destination.isVisited())) {
                    depthFirstSearch(destination);

                }
            }
        }
    }

    public void breadthFirstSearch(City originCity) {

        LinkedListQueue<City> queue=new LinkedListQueue<City>();
        queue.addToQueue(originCity);
        while(!queue.isEmpty())
        {
            City c=queue.dequeue();
            if(!c.isVisited())
            {
                c.visit();
                List<City> destinations = adjacencyList.get(c);
                if(destinations!=null && destinations.size()>0)
                {
                    queue.addItemsToQueue(destinations);
                }

            }

        }

    }
}