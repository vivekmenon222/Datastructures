package com.company;

import java.util.*;

/**
 * This class assumes the graph is directed
 */
public class TaskGraph {
    private Map<Task, LinkedList<Task>> taskGraph = new HashMap<>();
    private LinkedList<Task> topologicalSortedTask = new LinkedList<>();

    public void addTask(Task sourceTask, Task destinationTask) {
        LinkedList<Task> destinations = taskGraph.get(sourceTask);
        if (destinations == null) {
            destinations = new LinkedList<Task>();
            taskGraph.put(sourceTask, destinations);
        }
        destinations.add(destinationTask);
    }

    public void topologicalSortPrint() {
        depthFirstSearch();
        System.out.println("----Topological sort----");
        for (Task t : topologicalSortedTask) {
            System.out.println(t);
        }
    }

    private void depthFirstSearch() {

        for (Task sourceTask : taskGraph.keySet()) {
            if (sourceTask.isVisited() == false) {
                depthFirstSearchVisit(sourceTask);
            }

        }
    }

    private void depthFirstSearchVisit(Task sourceTask) {
        System.out.println("Visiting:" + sourceTask);

        sourceTask.setInProcess(true);
        sourceTask.setVisited(true);
        LinkedList<Task> destinations = taskGraph.get(sourceTask);
        if (destinations != null) {
            for (Task destination : destinations) {
                if (destination.isInProcess()) {
                    System.out.println("back edge from " + sourceTask + " to " + destination);
                }
                if (destination.isVisited() == false) {
                    destination.setParent(sourceTask);

                    depthFirstSearchVisit(destination);
                }
            }
        }

        sourceTask.setInProcess(false);
        topologicalSortedTask.addFirst(sourceTask);
    }

    private Date getCurentDate() {
        return new Date();
    }


}
