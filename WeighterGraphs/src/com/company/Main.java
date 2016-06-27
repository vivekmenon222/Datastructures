package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

   public static void main(String[] args) {

      City bos =new City("BOS") ;
      City pvd = new City("PVD");
      City ord = new City("ORD");
      City jfk = new City("JFK");
      City bwi = new City("BWI");
      City mia = new City("MIA");
      City dfw = new City("DFW");
      City lax = new City("LAX");
      City sfo = new City("SFO");
      AirportsGraph airportsGraph = new AirportsGraph();
      airportsGraph.addCity(bos);
      airportsGraph.addCity(pvd);
      airportsGraph.addCity(ord);
      airportsGraph.addCity(jfk);
      airportsGraph.addCity(bwi);
      airportsGraph.addCity(mia);
      airportsGraph.addCity(dfw);
      airportsGraph.addCity(lax);
      airportsGraph.addCity(sfo);

      airportsGraph.addEdge(new Edge(bos, sfo, 2704));
      airportsGraph.addEdge(new Edge(bos, ord, 867));
      airportsGraph.addEdge(new Edge(bos, jfk, 187));
      airportsGraph.addEdge(new Edge(bos, mia, 1256));
      airportsGraph.addEdge(new Edge(pvd, ord, 849));
      airportsGraph.addEdge(new Edge(pvd, jfk, 144));
      airportsGraph.addEdge(new Edge(jfk, dfw, 1391));
      airportsGraph.addEdge(new Edge(jfk, bwi, 184));
      airportsGraph.addEdge(new Edge(jfk, ord, 740));
      airportsGraph.addEdge(new Edge(jfk, mia, 1090));
      airportsGraph.addEdge(new Edge(bwi, mia, 946));
      airportsGraph.addEdge(new Edge(bwi, ord, 621));
      airportsGraph.addEdge(new Edge(ord, dfw, 802));
      airportsGraph.addEdge(new Edge(ord, sfo, 1846));
      airportsGraph.addEdge(new Edge(dfw, lax, 1238));
      airportsGraph.addEdge(new Edge(dfw, sfo, 1464));
      airportsGraph.addEdge(new Edge(dfw, mia, 1121));
      airportsGraph.addEdge(new Edge(lax, mia, 2342));
      airportsGraph.addEdge(new Edge(lax, sfo, 337));

      airportsGraph.createMinSpanningTree();

      System.out.println("------------------------------------------");
      System.out.println("-------FINAL PATHS-----------");
      System.out.println("------------------------------------------");
      airportsGraph.breadthFirstSearch(bos,true);

   }
}