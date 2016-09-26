package com.company;


public class Main {

    public static void main(String[] args) throws Exception {


        int[] sortMe = new int[]{1, 8, 4, 5, 2, 3, 6, 2, 8, 52, 7};


        System.out.println("Before Sort");
        arrayPrint(sortMe);

        MergeSort mergeSort = new MergeSort();

        mergeSort.Sort(sortMe);

        System.out.println("After Sort");
        arrayPrint(sortMe);

    }

    private static void arrayPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
