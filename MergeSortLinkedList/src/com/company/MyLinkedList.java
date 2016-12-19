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

         mergeAndSort(head.next);
    }

    private void mergeAndSort(ListNode beginNode)
    {
        ListNode leftBegin=beginNode;
        ListNode middle=getMidPoint(beginNode);
        ListNode rightBegin=middle.next;
        middle.next=null;
        if(leftBegin!=null && leftBegin.next!=null)
        {
            mergeAndSort(leftBegin);
        }

        if(rightBegin!=null && rightBegin.next!=null)
        {
            mergeAndSort(rightBegin);
        }
        mergeOnly(leftBegin,rightBegin);


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

    private void mergeOnly(ListNode leftBegin, ListNode rightBegin)
    {
        System.out.println("");
        System.out.println("****Merging Lists*****");
        System.out.println("Left list:");

        ListNode leftPointer=leftBegin;
        ListNode rightPointer=rightBegin;
        if(leftPointer!=null)
        {
            System.out.print(leftPointer.value+",");
            leftPointer=leftPointer.next;
        }
        System.out.println("");

        System.out.println("Right list:");
        if(rightPointer!=null)
        {
            System.out.print(rightPointer.value+",");
            rightPointer=rightPointer.next;
        }
        System.out.println("");
        System.out.println("*******************");

    }


}

