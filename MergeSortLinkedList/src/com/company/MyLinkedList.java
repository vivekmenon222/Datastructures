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
        split(head.next, null);

    }

    private void split(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;


        //move slow pointer once and fast pointer twice till you reach the end
        while (fast != end && fast.next != end) {

            fast = fast.next.next;
            slow = slow.next;//move slow forward only if fast can move 2 steps ahead

            if (end == null) {
                //This will set the end node when you are at the end or one node behind end
                end = trySetEndNode(fast);
            }
        }

        if (fast.next == end) {
            fast = fast.next;
        }

        /*You have reached the end,
        * the part from start till slow node is the first list (left list)
        * the part after the slow node, till the fast node is the 2nd list (right list)
        * */
        //split left side
        if (start != slow) {
            System.out.println("start:" + start.value + " end:" + slow.value);
            split(start, slow);
        }


        //split right side
        if (slow.next != fast) {
            System.out.println("start:" + slow.next.value + " end:" + fast.value);
            split(slow.next, fast);
        }


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
}

