package DoublyLinkedList;

import java.util.Iterator;

public class DlistImpl<T> implements  Dlist<T> {

    private int size;
    private DListNode<T> sentinel;

    public DlistImpl() {
        sentinel = new DListNode<T>(null, null, null, null);//passing sentinel for next and prev won't help because its null at this point.
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
        size = 0;

    }



    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }



    public int getSize() {
        return size;
    }

    void decrementSize() {
        size--;
    }



    public void insertFront(T item) throws NullNodeException {
        DListNode<T> newNode = new DListNode<T>(item, this, sentinel, sentinel.getNext());
        syncPrevAndNextNodes(newNode);
        size++;
    }


    public void insertEnd(T item) throws NullNodeException {
        DListNode<T> newNode = new DListNode<T>(item, this, sentinel.getPrevious(), sentinel);
        syncPrevAndNextNodes(newNode);
        size++;
    }



    public void insertAt(int index, T item) throws NullNodeException {
        DListNode<T> beforeThisNode;
        if (index == 0) {
            insertFront(item);
        } else if (index == size) {
            insertEnd(item);
        } else {
            beforeThisNode = getNodeAt(index);
            DListNode<T> newNode = new DListNode<T>(item, this, beforeThisNode.getPrevious(), beforeThisNode);
            syncPrevAndNextNodes(newNode);
            size++;
        }
    }


    private void syncPrevAndNextNodes(DListNode<T> newNode) {
        newNode.getNext().setPrevious(newNode);
        newNode.getPrevious().setNext(newNode);
    }


    public T front() {
        return frontNode().getItem();
    }

    private DListNode<T> frontNode() {
        return sentinel.getNext();
    }


    public T back() {
        return backNode().getItem();
    }

    private DListNode<T> backNode() {
        return sentinel.getPrevious();
    }



    public T get(int index) throws NullNodeException {
        return getNodeAt(index).getItem();
    }

    private DListNode<T> getNodeAt(int index) throws NullNodeException {
        checkIndexValidity(index);
        DListNode<T> node;
        if (isIndexCloserToFront(index)) {
            node = frontNode();
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = backNode();
            for (int i = (size - 1); i > index; i--) {
                node = node.getPrevious();
            }
        }
        return node;
    }


    public void removeAt(int index) throws NullNodeException {
        DListNode<T> removeNode = getNodeAt(index);
        remove(removeNode);
    }


    public void removeFirst() {
        remove(frontNode());
    }



    public void removeLast() {
        remove(backNode());
    }

    private void remove(DListNode<T> node) {
        if (node.isValid()) {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            node.setParentList(null);
            size--;
        }
    }


    public Iterator<T> iterator() {
        return new DListIterator<T>(sentinel);
    }

    private void checkIndexValidity(int index) throws NullNodeException {
        if (!(index >= 0 && index < size)) {
            throw new NullNodeException(String.format("%s is not a valid node index", index));
        }
    }

    private boolean isIndexCloserToFront(int index) {
        if (index > (size / 2)) {
            return false;
        } else {
            return true;
        }
    }
}
