package com.company;

public class Edge {
   City sourceCity;
   City destinationCity;
   int weight;


   public Edge(City sourceCity, City destinationCity, int weight) {
      this.sourceCity = sourceCity;
      this.destinationCity = destinationCity;
      this.weight = weight;

   }

   @Override
   public String toString() {
      return "Edge{" +
              "sourceCity=" + sourceCity +
              ", destinationCity=" + destinationCity +
              '}';
   }
}
