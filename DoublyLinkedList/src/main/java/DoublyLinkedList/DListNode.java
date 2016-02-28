package DoublyLinkedList;


class DListNode<T>  {
    private T item;
    private DlistImpl<T> parentList;
    private DListNode<T> previous;
    private DListNode<T> next;



    DListNode(T item, DlistImpl<T> parentList, DListNode<T> prev, DListNode<T> next) {
        this.item = item;
        this.setParentList(parentList);
        this.setPrevious(prev);
        this.setNext(next);
    }

    T getItem() {
        return item;
    }


    DListNode<T> getPrevious() {
        return previous;
    }

    void setPrevious(DListNode<T> previous) {
        this.previous = previous;
    }

    DListNode<T> getNext() {
        return next;
    }

    void setNext(DListNode<T> next) {
        this.next = next;
    }

    DlistImpl<T> getParentList() {
        return parentList;
    }

    void setParentList(DlistImpl<T> parentList) {
        this.parentList = parentList;
    }

    Boolean isValid() {
        if (this.getParentList() != null) {
            return true;
        } else {
            return false;
        }
    }
}
