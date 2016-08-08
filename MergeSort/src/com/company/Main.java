package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList linkedList=new LinkedList();

        linkedList.insertFront(7);
        linkedList.insertFront(6);
        linkedList.insertFront(8);
        linkedList.insertFront(19);
        linkedList.insertFront(2);
        linkedList.insertFront(15);
        linkedList.insertFront(9);
        linkedList.insertFront(5);
        linkedList.insertFront(22);
        System.out.println("Before Sort");

        for(ListNode listNode:linkedList)
        {
          System.out.println(listNode.value);
        }
        MergeSort mergeSort=new MergeSort();

        mergeSort.Sort(linkedList);

        System.out.println("After Sort");
        for(ListNode listNode:linkedList)
        {
            System.out.println(listNode.value);
        }
    }
}
