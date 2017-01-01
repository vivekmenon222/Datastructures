package com.company;

import java.lang.invoke.ConstantCallSite;

/**
 * Created by Home on 6/5/2016.
 */
public class City {

    private String name;
    private boolean visited;
    private int depth;
    private City parent;

    public City(String name) {
        this.name = name.toLowerCase();
    }


    public String getName() {
        return name;
    }

    public void visit(City parent) {
        this.visited = true;
        this.parent = parent;
        if (parent == null) {
            this.depth = 0;
        } else {
            this.depth = this.parent.getDepth() + 1;
        }

        System.out.println("Visiting:" + this.name);
        System.out.println("Depth:" + this.depth);
        System.out.println("-----------------");
    }

    @Override
    public int hashCode() {
        return name.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        boolean returnVal = false;
        if (obj == null || !(obj instanceof City)) {
            returnVal = false;
        } else if (((City) obj).name.equals(this.name)) {
            returnVal = true;
        }

        return returnVal;
    }


    public boolean isVisited() {
        return visited;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }
}