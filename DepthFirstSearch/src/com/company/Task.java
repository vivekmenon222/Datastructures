package com.company;

import java.util.Date;

/**
 * Created by Home on 1/2/2017.
 */
public class Task {
    private  String taskName;
    private Task Parent;
    private Date discoveryTime;
    private Date finishTime;
    private boolean visited;

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

    public Date getDiscoveryTime() {
        return discoveryTime;
    }

    public void setDiscoveryTime(Date discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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


}
