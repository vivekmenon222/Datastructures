package com.company;

/**
 * Created by Home on 12/23/2018.
 */
public class Node implements Comparable<Node> {
    //For simplicity assume name to be the identifier
    public String name;
    public int distanceFromSource;
    public boolean queued;
    public Node parent;

    public Node(String name) {
        this.name = name;
        this.distanceFromSource = Integer.MAX_VALUE;
        this.queued = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name.equals(node.name);

    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Node that) {
        return this.distanceFromSource - that.distanceFromSource;
    }
}
