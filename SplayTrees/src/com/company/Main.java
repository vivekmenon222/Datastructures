package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here


        SplayTree splayTree = new SplayTree();
        //Insert values
        splayTree.insert(new Entry(1, "Jack"));
        splayTree.insert(new Entry(6, "Tom"));
        splayTree.insert(new Entry(4, "Raj"));
        splayTree.insert(new Entry(7, "Kareena"));
        splayTree.insert(new Entry(8, "John"));
        splayTree.insert(new Entry(10, "Susan"));
        splayTree.insert(new Entry(5, "Linda"));
        splayTree.insert(new Entry(9, "Peter"));

        //Find
        System.out.println(splayTree.find(6));
        System.out.println(splayTree.find(1));
        System.out.println(splayTree.find(7));

        //Sort
        System.out.println("--Print sorted--");
        splayTree.printSorted();


    }
}
