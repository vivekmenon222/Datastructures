package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");
        City G = new City("G");

        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(A, B, 10));
        edges.add(new Edge(B, C, 5));
        edges.add(new Edge(C, E, 5));
        edges.add(new Edge(E, F, 1));
        edges.add(new Edge(E, D, 2));
        edges.add(new Edge(F, G, 10));
        edges.add(new Edge(B, D, 13));
        edges.add(new Edge(D, G, 1));

        Dijkstra dijkstra=new Dijkstra(edges);
        dijkstra.findShortestPathFrom(A);
        dijkstra.printShortestPathTo(G);

    }
}
