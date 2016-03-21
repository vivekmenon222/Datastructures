package com.company;

import java.util.Iterator;

/**
 * Created by Home on 3/6/2016.
 */
public class MyCollection<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new MyCollectionIterator<T>();
    }
}
