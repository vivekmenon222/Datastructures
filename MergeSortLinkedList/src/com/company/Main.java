package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();



        myLinkedList.insertFront(12);
        myLinkedList.insertFront(3);

        myLinkedList.insertFront(4);
        myLinkedList.insertFront(1);
        myLinkedList.insertFront(5);

       myLinkedList.insertFront(11);
        System.out.println(myLinkedList);

        myLinkedList.sort();
        System.out.println(myLinkedList);
       // LinkedList<String> linkedList=new LinkedList<String>();
       // linkedList.sort();

    }
}
