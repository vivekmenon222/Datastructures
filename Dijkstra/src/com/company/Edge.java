package com.company;

/**
 * Created by Home on 12/23/2018.
 */
public class Edge {
    public Node start;
    public Node end;
    public int weight;

    public Edge(Node start, Node end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge that = (Edge) o;

        if (this.start.equals(that.start) && this.end.equals(that.end)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }




}
