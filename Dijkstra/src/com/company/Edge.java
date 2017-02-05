package com.company;


public class Edge implements Comparable<Edge> {
    private City originCity;
    private City destCity;
    private int weight;

    public Edge(City originCity, City destCity, int weight) {
        this.originCity = originCity;
        this.destCity = destCity;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.weight, that.weight);

    }

    public City getOriginCity() {
        return originCity;
    }

    public City getDestCity() {
        return destCity;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int result = originCity.hashCode()*10 + destCity.hashCode() + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "originCity=" + originCity +
                ", destCity=" + destCity +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object thatEdgeObj) {
        boolean isEqual;
        if (!(thatEdgeObj instanceof Edge)) {
            isEqual = false;
        } else {
            Edge thatEdge = (Edge) thatEdgeObj;
            if (this.getOriginCity().equals(thatEdge.getOriginCity()) && this.getDestCity().equals(thatEdge.getDestCity())) {
                isEqual = true;
            } else {
                isEqual = false;
            }
        }
        return isEqual;
    }


}