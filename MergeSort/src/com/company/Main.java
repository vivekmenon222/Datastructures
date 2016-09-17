package com.company;


public class Main {

    public static void main(String[] args) throws Exception {
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
        linkedList.insertFront(9);
    /*    linkedList.insertFront(2);
        linkedList.insertFront(6);
        linkedList.insertFront(8);
        linkedList.insertFront(4);*/


     //   System.out.println("Before Sort");

       // linkedList.print();
        MergeSort mergeSort=new MergeSort();

        mergeSort.Sort(linkedList);

       // System.out.println("After Sort");
      //  linkedList.print();
    }


}
