package DoublyLinkedList;

import java.util.Iterator;


public interface Dlist<T> extends Iterable<T> {
    Boolean isEmpty();

    int getSize();

    void insertFront(T item) throws NullNodeException;

    void insertAt(int index,T item) throws NullNodeException;

    void insertEnd(T item) throws NullNodeException;

    T front();

    T get(int index) throws NullNodeException;

    T back();

    void removeFirst();

    void removeAt(int index) throws NullNodeException;

    void removeLast();

    Iterator<T> iterator();
}
