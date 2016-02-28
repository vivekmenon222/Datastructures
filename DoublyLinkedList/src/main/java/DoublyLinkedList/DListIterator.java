package DoublyLinkedList;

import java.util.Iterator;

public class DListIterator<T> implements Iterator<T> {


    DListNode<T> currentNode;

    public DListIterator(DListNode<T> sentinel)
    {
        currentNode=sentinel;
    }


    public boolean hasNext() {
        return currentNode.getNext().isValid();
    }


    public T next() {
        currentNode=currentNode.getNext();
        return currentNode.getItem();

    }


    public void remove() {
        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.getParentList().decrementSize();
        currentNode.setParentList(null);
    }
}
