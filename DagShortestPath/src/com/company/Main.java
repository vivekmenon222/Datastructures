package com.company;

public class Main {

   public static void main(String[] args) {
      // write your code here
      City cityA = new City("A");
      City cityB = new City("B");
      City cityC = new City("C");
      City cityD = new City("D");
      City cityE = new City("E");

      Dag dag = new Dag();
      dag.addEdge(new Edge(cityA, cityB, 1));
      dag.addEdge(new Edge(cityA, cityD, 5));
      dag.addEdge(new Edge(cityB, cityC, 2));
      dag.addEdge(new Edge(cityB, cityD, 3));
      dag.addEdge(new Edge(cityB, cityE, 7));
      dag.addEdge(new Edge(cityC, cityE, 3));
      dag.addEdge(new Edge(cityD, cityE, 1));
      System.out.println(dag.findDistance(cityA, cityE));

   }
}
