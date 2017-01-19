package com.company;

import java.util.LinkedList;

/**
 * The bucket is a queue of integers (first in first out)
 */
public class Bucket {
    LinkedList<Integer> ints;
    private int count=0;

    public Bucket() {
        ints = new LinkedList<Integer>();
    }

    public void add(int i) {
        ints.add(i);
        count++;
    }

    public int remove()
    {
        count--;
        return ints.removeFirst();
    }


    public int getCount() {
        return count;
    }
}
