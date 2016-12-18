package com.company;

import java.util.Iterator;
import java.util.List;

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
        split(head, head.next, null);

    }

    private void split(ListNode dummyHead, ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;


        //move slow pointer once and fast pointer twice till you reach the end
        //if we have odd number of elements and we keep jumping 2 elements we will overshoot the end by one item
        //thats why need to stop at one before end in the while loop
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;//move slow forward only if fast can move 2 steps ahead

            if (end == null) {
                //Will enter here only in the first iteration
                //This will set the end node when you are at the end or one node behind end
                end = trySetEndNode(fast);
            }
        }

        if (fast.next == end) {
            fast = fast.next;
        }

        /*You have reached the end of the linkedlist you are iterating thru,
        * the part from start till slow node is the first list (left list)
        * the part after the slow node, till the fast node is the 2nd list (right list)
        * */
        //recursively split left side
        if (start != slow) {
            split(dummyHead, start, slow);
        }


        //recursively split right side
        if (slow.next != fast) {
            split(slow, slow.next, fast);
        }

        merge(dummyHead, start,slow, slow.next, fast);

    }

    private ListNode trySetEndNode(ListNode fast) {
        //This will happen only in the very first iteration.
        // Since we didn't know the last node we passed in a null
        ListNode end = null;
        if (fast.next == null) {
            end = fast;
        } else if (fast.next.next == null) {
            end = fast.next;
        }

        return end;

    }

    private void merge(ListNode dummyHead, ListNode leftBegin,ListNode LeftEnd, ListNode rightBegin, ListNode rightEnd) {
        System.out.println("*********************************************");
        System.out.println("List in:" + this);
        System.out.println("*********************************************");

        ListNode preLeftPointer = dummyHead;
        ListNode leftPointer = leftBegin;
        ListNode rightPointer = rightBegin;
        while (leftPointer != null && rightPointer != null && leftPointer != LeftEnd.next && rightPointer != rightEnd.next) {
            if (leftPointer.value <= rightPointer.value) {
                preLeftPointer = leftPointer;
                leftPointer = leftPointer.next;
            } else {
                ListNode postRightPointer = rightPointer.next;
                rightPointer.next = leftPointer;
                preLeftPointer.next = rightPointer;
                preLeftPointer = preLeftPointer.next;
                leftPointer.next = postRightPointer;
                rightPointer = postRightPointer;

                String s = "";

            }
            System.out.println("--Intermediate Results--");

            System.out.println("dummyHead:" + dummyHead.value);
            System.out.println("leftBegin:" + leftBegin.value);
            System.out.println("rightBegin:" + rightBegin.value);
            System.out.println("rightEnd:" + rightEnd.value);

            System.out.println("leftPointer:" + (leftPointer != null ? leftPointer.value : "null"));
            System.out.println("rightPointer:" + (rightPointer != null ? rightPointer.value : "null"));
            System.out.println(" List out:" + this);
            System.out.println("----------------------------");
        }
        System.out.println("--Exit while Results--");

        System.out.println("dummyHead:" + dummyHead.value);
        System.out.println("leftBegin:" + leftBegin.value);
        System.out.println("rightBegin:" + rightBegin.value);
        System.out.println("rightEnd:" + rightEnd.value);

        System.out.println("leftPointer:" + (leftPointer != null ? leftPointer.value : "null"));
        System.out.println("rightPointer:" + (rightPointer != null ? rightPointer.value : "null"));
        System.out.println(" List out:" + this);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");



    }
}

