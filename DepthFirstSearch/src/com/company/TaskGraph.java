package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class assumes the graph is directed
 */
public class TaskGraph {
    private Map<Task, LinkedList<Task>> taskGraph = new HashMap<>();

    public void addTask(Task sourceTask, Task destinationTask) {
        LinkedList<Task> destinations = taskGraph.get(sourceTask);
        if (destinations == null) {
            destinations = new LinkedList<Task>();
            taskGraph.put(sourceTask, destinations);
        }
        destinations.add(destinationTask);
    }

    public void topologicalSortPrint() {

    }

    public void depthFirstSearch() {
        for (Task sourceTask : taskGraph.keySet()) {
            if (sourceTask.isVisited() == false) {
                depthFirstSearchVisit(sourceTask);
            }

        }
    }

    private void depthFirstSearchVisit(Task sourceTask) {
        System.out.println("Visiting:" + sourceTask);
        sourceTask.setVisited(true);
        LinkedList<Task> destinations = taskGraph.get(sourceTask);
        if (destinations != null) {
            for (Task destination : destinations) {
                if (destination.isVisited() == false) {
                    depthFirstSearchVisit(destination);
                }
            }
        }


    }


}
