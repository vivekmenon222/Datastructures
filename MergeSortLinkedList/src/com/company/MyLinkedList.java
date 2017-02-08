package com.company;

import java.util.Iterator;

public class MyLinkedList implements Iterable<ListNode> {

    ListNode head;
    private int count = 0;

    public MyLinkedList() {
        head = new ListNode(0, null);
    }

    public void insertFront(int item) {
        ListNode nextNode = head.next != null ? head.next : null;
        ListNode newNode = new ListNode(item, head.next);
        head.next = newNode;
        count++;
    }


    @Override
    public String toString() {
        Iterator<ListNode> iterator = this.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (iterator.hasNext()) {
            sb.append(iterator.next().value);
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<ListNode> iterator() {

        return new Iterator<ListNode>() {
            ListNode currentNode = head;

            @Override
            public boolean hasNext() {
                if (currentNode.next == null || currentNode.next == head) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public ListNode next() {
                currentNode = currentNode.next;
                return currentNode;
            }
        };
    }

    public int getCount() {
        return count;
    }

    public void sort() {

        head.next = split(head.next);
    }

    private ListNode split(ListNode beginNode) {
        ListNode leftBegin = beginNode;
        ListNode middle = getMidPoint(beginNode);
        ListNode rightBegin = middle.next;
        middle.next = null;//this step is critical.
        if (leftBegin != null && leftBegin.next != null) {
            //splitting stops when we have just one node
            leftBegin = split(leftBegin);
        }

        if (rightBegin != null && rightBegin.next != null) {
            //splitting stops when we have just one node
            rightBegin = split(rightBegin);
        }
        return merge(leftBegin, rightBegin);


    }

    private ListNode getMidPoint(ListNode beginNode) {

        ListNode leftpointer = beginNode;
        ListNode rightPointer;
        if (beginNode.next != null) {
            rightPointer = leftpointer.next;
        } else {
            //This means you have just one element
            return leftpointer;
        }

        while (rightPointer != null) {
            rightPointer = rightPointer.next;
            if (rightPointer != null) {
                rightPointer = rightPointer.next;
                leftpointer = leftpointer.next;
            }
        }
        return leftpointer;

    }

    private ListNode merge(ListNode leftBegin, ListNode rightBegin) {
        ListNode leftPointer = leftBegin;
        ListNode rightPointer = rightBegin;
        ListNode leftPrev = null;
        ListNode firstElement = null;

        while (leftPointer != null && rightPointer != null) {
            if (leftPointer.value < rightPointer.value) {
                if (firstElement == null) {
                    firstElement = leftPointer;
                }
                leftPrev = leftPointer;
                leftPointer = leftPointer.next;

            } else {
                if (firstElement == null) {
                    firstElement = rightPointer;
                }

                ListNode nextRight = rightPointer.next;
                if (leftPrev != null) {
                    leftPrev.next = rightPointer;
                }
                rightPointer.next = leftPointer;
                leftPrev = rightPointer;
                rightPointer = nextRight;
            }

        }

        if (rightPointer != null) {
            leftPrev.next = rightPointer;

        }
        return firstElement;

    }


}

