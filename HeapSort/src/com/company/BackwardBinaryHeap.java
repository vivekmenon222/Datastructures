package com.company;

/**
 * Created by Home on 8/2/2016.
 */
public class BackwardBinaryHeap {

    private int[] sortedArr;
    private int[] backwardHeap;
    private int maxIndex;
    private int lastInnerChildIndex;

    public BackwardBinaryHeap(int[] arr) {
        backwardHeap = arr;
        maxIndex = backwardHeap.length - 1;
        lastInnerChildIndex = getParentIndex(0);
        createBottomUpHeap(lastInnerChildIndex);
        for (int i : backwardHeap) {
            System.out.println(i);
        }
    }

    private void createBottomUpHeap(int processIndex) {
        while (processIndex <= maxIndex) {
            System.out.println("process Index:" + processIndex);
            bubbleDown(processIndex);
            processIndex++;
        }

    }

    private void bubbleDown(int index) {
        int firstChildIndex = getReversedIndex(2 * getReversedIndex(index));
        System.out.println("firstChildIndex:" + firstChildIndex);
        int secondChildIndex = getReversedIndex(2 * getReversedIndex(index) + 1);

        int minChildIndex = backwardHeap[firstChildIndex] < backwardHeap[secondChildIndex] ? firstChildIndex : secondChildIndex;
        if (backwardHeap[index] > backwardHeap[minChildIndex]) {
            swap(index, minChildIndex);
            if (minChildIndex >= lastInnerChildIndex) {
                bubbleDown(minChildIndex);
            }

        }

    }


    private int getReversedIndex(int regularIndex) {
        return (maxIndex - regularIndex) + 1;
    }


    private int getParentIndex(int itemIndex) {
        return getReversedIndex((int) (getReversedIndex(itemIndex) / 2));
    }


    private void swap(int x, int y) {
        int temp = backwardHeap[x];
        backwardHeap[x] = backwardHeap[y];
        backwardHeap[y] = temp;
    }


    public int[] getSortedArr() {
        return sortedArr;
    }


}
