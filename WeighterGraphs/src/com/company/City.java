package com.company;

/**
 * Created by Home on 1/3/2017.
 */
public class City {
    private String name;
    private City parent;
    private boolean isVisited;

    public City(String name) {
        this.name=name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


    @Override
    public boolean equals(Object thatObj) {
        //If the city has the same name name then its the same city
        boolean isEqual = false;
        if ((thatObj == null) || !(thatObj instanceof City)) {
            isEqual = false;
        } else if (((City) thatObj).getName().equals(this.getName())) {
            isEqual = true;
        }
        return isEqual;

    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getParent() {
        return parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
       this.isVisited=visited;
    }

    public void visit(City parent)
    {
        this.parent = parent;
        this.isVisited=true;
    }
}
