package com.company;


public class City implements Comparable<City> {
    private String name;
    private City parent;
    private int totalWeight=Integer.MAX_VALUE;


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



    public void visit(City parent)
    {
        this.setParent(parent);
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(City that)
    {
        return Integer.compare(this.getTotalWeight(),that.getTotalWeight());
    }
}