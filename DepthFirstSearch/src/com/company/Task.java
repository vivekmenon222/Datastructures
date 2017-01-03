package com.company;

import java.util.Date;

/**
 * Created by Home on 1/2/2017.
 */
public class Task {
    private String taskName;
    private Task Parent;
    private boolean visited;
    private boolean inProcess;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Task getParent() {
        return Parent;
    }

    public void setParent(Task parent) {
        Parent = parent;
    }


    @Override
    public String toString() {
        return taskName;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


    public boolean isInProcess() {
        return inProcess;
    }

    public void setInProcess(boolean inProcess) {
        this.inProcess = inProcess;
    }
}
