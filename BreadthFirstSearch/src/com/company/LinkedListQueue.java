package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 6/12/2016.
 */
public class LinkedListQueue<T> extends LinkedList<T> {

    LinkedList<T> linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList<T>();
    }

    public void addToQueue(T item) {
        linkedList.add(item);
    }

    public void addItemsToQueue(List<T> items) {
        for (T item : items) {
            linkedList.add(item);
        }

    }

    public T dequeue() {
        if (linkedList.size() > 0) {
            return linkedList.removeFirst();
        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        return (linkedList.size() == 0);
    }
}