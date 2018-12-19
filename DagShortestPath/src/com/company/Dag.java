package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dag {
   private List<Edge> edges = new ArrayList<>();
   //map of city to outgoing edges
   private Map<City, List<Edge>> cityMap = new HashMap<>();
   private Stack<City> cityStack = new Stack<>();

   public void addEdge(Edge edge) {
      if (!cityMap.containsKey(edge.sourceCity)) {
         cityMap.put(edge.sourceCity, new ArrayList<>());
      }

      if (!cityMap.containsKey(edge.destinationCity)) {
         cityMap.put(edge.destinationCity, new ArrayList<>());
      }

      cityMap.get(edge.sourceCity).add(edge);
      this.edges.add(edge);
   }

   public int findDistance(City source, City destination) {

      //sort the cities according to the direction of the edges
      topologicalSort();

      //Starting from the first city in the topologically sorted cities
      //relax all the outgoing edges
      while (!cityStack.isEmpty()) {
         City currentSource = cityStack.pop();
         System.out.println(currentSource);

         if (currentSource.equals(source)) {
            source.distanceFromSource = 0;
         }

         List<Edge> outgoingEdges = cityMap.get(currentSource);

         //Relax all the outgoing edges
         if (outgoingEdges != null) {

            for (Edge e : outgoingEdges) {
               City currentDestination = e.destinationCity;
               int newCalculatedDist = Integer.MAX_VALUE;

               //The check below is required to avoid the overflow of int
               if (currentSource.distanceFromSource != Integer.MAX_VALUE) {
                  newCalculatedDist = currentSource.distanceFromSource + e.weight;
               }

               //If the newly calculated distance is less than what was
               //the distance to that city before, then update it.
               if (currentDestination.distanceFromSource
                       > newCalculatedDist) {
                  currentDestination.distanceFromSource = newCalculatedDist;
                  currentDestination.parent=currentSource;

               }

            }
         }

      }

      return destination.distanceFromSource;

   }

   private void topologicalSort() {

      for (City c : cityMap.keySet()) {
         if (c.isVisited == false) {
            dfs(c);
         }
      }

   }

   private void dfs(City source) {

      source.inProcess = true;
      source.isVisited = true;
      List<Edge> outGoingEdges = cityMap.get(source);

      if (outGoingEdges != null) {

         for (Edge e : outGoingEdges) {

            City destinationCity = e.destinationCity;

            if (destinationCity.inProcess == true) {
               String msg = String.format("Loop detected between %s and %s", e.destinationCity,
                       e.sourceCity);
               throw new RuntimeException(msg);
            }

            if (e.destinationCity.isVisited == false) {
               dfs(e.destinationCity);
            }

         }

      }

      source.inProcess = false;
      cityStack.push(source);

   }
}
