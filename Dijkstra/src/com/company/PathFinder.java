package com.company;

import java.util.*;

/**
 * Created by Home on 12/23/2018.
 */
public class PathFinder {
    //map of node to outgoing edges
    Map<Node, List<Edge>> nodeMap = new HashMap<>();
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    public void addPath(Node start, Node end, int weight) {
        Edge edge = new Edge(start, end, weight);
        if (nodeMap.get(start) == null) {
            List<Edge> edges = new ArrayList<>();
            nodeMap.put(start, edges);
        }

        List<Edge> outGoingEdges = nodeMap.get(start);
        outGoingEdges.add(edge);

    }

    public int findDistance(Node start, Node end) {

        start.distanceFromSource = 0;
        priorityQueue.add(start);
        while (priorityQueue.isEmpty() == false) {
            Node extractedNode = priorityQueue.remove();
            if (extractedNode.equals(end)) {
                break;
            }

            List<Edge> outGoingEdges = nodeMap.get(extractedNode);
            relaxEdges(outGoingEdges);
        }

        printPath(end);

        return end.distanceFromSource;
    }

    private void printPath(Node end) {
        System.out.println("Shortest Path:");
        Stack<Node> nodeStack = new Stack<>();
        Node node = end;

        while (node != null) {
            nodeStack.push(node);
            node = node.parent;
        }

        while (!nodeStack.isEmpty()) {
            Node poppedNode = nodeStack.pop();
            System.out.println(poppedNode);
        }

    }


    private void relaxEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            Node currSource = edge.start;
            Node currDest = edge.end;
            int weight = edge.weight;
            int newNodeDistance = weight + currSource.distanceFromSource;

            if (newNodeDistance < currDest.distanceFromSource) {
                currDest.distanceFromSource = newNodeDistance;
                currDest.parent = currSource;

                //Queue a node only once
                if (currDest.queued == false) {
                    priorityQueue.add(currDest);
                    currDest.queued = true;
                }
            }
        }

    }
}
