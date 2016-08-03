package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={8,6,4,9,2,5,7,23,99,52,3,2};
        HeapSort heapSort=new HeapSort();
        heapSort.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
