package com.company;

/**
 * Created by Home on 8/3/2016.
 */
public class HeapSort {

    public void sort(int[] array)
    {
        BackwardBinaryHeap bckHeap= new BackwardBinaryHeap(array);
        bckHeap.sort();
    }
}
