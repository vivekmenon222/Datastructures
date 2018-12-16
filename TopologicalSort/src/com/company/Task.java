package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private List<Task> dependsOn = new ArrayList<>();
    UUID id;
    private boolean isVisited;

    public String getName() {
        return name;
    }


    private String name;

    public Task(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isInProcess() {
        return isInProcess;
    }

    public void setIsInProcess(boolean isInProcess) {
        this.isInProcess = isInProcess;
    }

    private boolean isInProcess;


    public void addDependency(Task task) {
        this.dependsOn.add(task);
    }

    public List<Task> getDependsOn() {
        return this.dependsOn;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);

    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
