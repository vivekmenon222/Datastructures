package com.company;

public class Main {

    public static void main(String[] args) {

        //Declare the nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        PathFinder pf = new PathFinder();

        //Add all the paths
        pf.addPath(nodeA, nodeB, 10);
        pf.addPath(nodeB, nodeC, 5);
        pf.addPath(nodeB, nodeD, 13);
        pf.addPath(nodeC, nodeE, 5);
        pf.addPath(nodeD, nodeG, 1);
        pf.addPath(nodeE, nodeD, 2);
        pf.addPath(nodeE, nodeF, 1);
        pf.addPath(nodeF, nodeG, 10);

        //Get the distance from source
        int dist = pf.findDistance(nodeA, nodeG);
        System.out.println("Distance from source:" + dist);
    }
}
