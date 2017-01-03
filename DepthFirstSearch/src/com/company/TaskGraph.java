package com.company;

import java.util.*;

/**
 * This class assumes the graph is directed
 */
public class TaskGraph {
    private Map<Task, LinkedList<Task>> taskGraph = new HashMap<>();
    private LinkedList<Task> topologicalSortedTask=new LinkedList<>();

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
        for(Task t:topologicalSortedTask)
        {
            System.out.println(t);
        }
    }

    public void depthFirstSearch() {
        for (Task sourceTask : taskGraph.keySet()) {
            if (sourceTask.isVisited() == false) {
                depthFirstSearchVisit(sourceTask);
            }

        }
    }

    private void depthFirstSearchVisit(Task sourceTask) {
       // System.out.println("Visiting:" + sourceTask);
        sourceTask.setDiscoveryTime(getCurentDate());
        sourceTask.setVisited(true);
        LinkedList<Task> destinations = taskGraph.get(sourceTask);
        if (destinations != null) {
            for (Task destination : destinations) {
                if (destination.isVisited() == false) {
                    destination.setParent(sourceTask);
                    depthFirstSearchVisit(destination);
                }
            }
        }
        sourceTask.setFinishTime(getCurentDate());
        topologicalSortedTask.addFirst(sourceTask);
    }

    private Date getCurentDate()
    {
        return new Date();
    }


}
