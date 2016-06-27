package com.company;

import java.util.*;

import javafx.scene.Parent;

/**
 * Created by Home on 6/5/2016.
 */
public class AirportsGraph {

   Map<City, List<City>> adjacencyList;
   List<Edge> edges= new ArrayList<Edge>();
   List<City> cities=new ArrayList<City>();

   public AirportsGraph() {
      adjacencyList = new HashMap<City, List<City>>();
   }

   public void addEdge(Edge e)
   {
      if(!edges.contains(e))
      {
         edges.add(e);
      }

   }

   public void addCity(City city)
   {
      if(!cities.contains(city))
      {
         cities.add(city);
      }

   }

   public void resetVisitedCities()
   {
      for(City c:cities)
      {
         c.resetVisited();
      }
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



   public void breadthFirstSearch(City originCity,boolean doPrint) {

      LinkedListQueue<QueueItem> queue=new LinkedListQueue<QueueItem>();
      QueueItem qi=new QueueItem(originCity,null);
      queue.addToQueue(qi);
      while(!queue.isEmpty())
      {
         QueueItem queueItem=queue.dequeue();
         City c=queueItem.getCity();
         City parent=queueItem.getParent();
         if(!c.isVisited())
         {
            c.visit(parent,doPrint);
            List<City> destinations = adjacencyList.get(c);
            if(destinations!=null && destinations.size()>0)
            {
               for(City destination:destinations)
               {
                  queue.addToQueue(new QueueItem(destination,c));
               }
            }

         }

      }

   }
   
   public void createMinSpanningTree()
   {
      Collections.sort(this.edges);

      for(Edge e: this.edges)
      {
         this.breadthFirstSearch(e.getCity1(),false);
         if(!e.getCity2().isVisited())
         {
            this.addPath(e.getCity1(), e.getCity2());
         }
         this.resetVisitedCities();

      }
   }
}