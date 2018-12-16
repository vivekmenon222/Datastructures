package com.company;

import java.util.*;

public class TopologicalSorter {

    //map of parent task to child tasks (parent needs to execute first)
    private Map<Task, List<Task>> adjacencyList = new HashMap<>();
    private List<Task> sortedTasks = new ArrayList<>();
    private Stack<Task> taskStack = new Stack<>();

    public void addTaskToSort(Task task) {

        if (task.getDependsOn() == null || task.getDependsOn().isEmpty()) {
            this.adjacencyList.put(task, null);
        } else {
            for (Task parent : task.getDependsOn()) {
                if (this.adjacencyList.get(parent) == null) {
                    this.adjacencyList.put(parent, new ArrayList<>());
                }

                this.adjacencyList.get(parent).add(task);

            }
        }

    }

    public List<Task> getSortedList() {

        for (Task parentTask : this.adjacencyList.keySet()) {
            if (parentTask.isVisited() == false) {
                dfs(parentTask);
            }
        }

        while (!this.taskStack.isEmpty()) {
            this.sortedTasks.add(taskStack.pop());
        }

        return this.sortedTasks;
    }

    private void dfs(Task task) {
        task.setIsVisited(true);
        task.setIsInProcess(true);

        List<Task> children = this.adjacencyList.get(task);
        if (children != null) {
            for (Task child : children) {

                if (child.isInProcess() == true) {
                    String msg = String.format("Cyclic dependency detected between %s and %s", child.getName(), task.getName());
                    throw new RuntimeException(msg);
                }

                if (child.isVisited() == false) {
                    dfs(child);
                }


            }

        }

        this.taskStack.push(task);
        task.setIsInProcess(false);


    }


}
