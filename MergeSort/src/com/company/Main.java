package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList linkedList=new LinkedList();

        linkedList.insertFront(4);
        linkedList.insertFront(2);
        linkedList.insertFront(3);
        linkedList.insertFront(1);
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
