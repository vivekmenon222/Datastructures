package com.company;

/**
 * Created by Home on 8/2/2016.
 */
public class BackwardBinaryHeap {

    private int[] backwardHeap;
    private int maxIndex;
    private int lastInnerChildIndex;

    public BackwardBinaryHeap(int[] arr) {
        backwardHeap = arr;
        maxIndex = backwardHeap.length - 1;
        lastInnerChildIndex = getParentIndex(0);
        createBottomUpHeap(lastInnerChildIndex);
    }

    private void createBottomUpHeap(int processIndex) {
        while (processIndex <= maxIndex) {
            bubbleDown(processIndex, 0);
            processIndex++;
        }

    }

    private void bubbleDown(int index, int stopIndex) {
        int firstChildIndex = getReversedIndex(2 * getReversedIndex(index));
        int secondChildIndex = getReversedIndex(2 * getReversedIndex(index) + 1);
        int minChildIndex;

        if (firstChildIndex < stopIndex) {
            return;
        }

        if (secondChildIndex < stopIndex) {
            minChildIndex = firstChildIndex;
        } else {
            minChildIndex = backwardHeap[firstChildIndex] < backwardHeap[secondChildIndex] ? firstChildIndex : secondChildIndex;
        }

        if (backwardHeap[index] > backwardHeap[minChildIndex]) {
            swap(index, minChildIndex);
            if (minChildIndex >= lastInnerChildIndex) {
                bubbleDown(minChildIndex, stopIndex);
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


    public void sort() {
        for (int i = 0; i <= maxIndex; i++) {
            removeMin(i);
        }
    }

    private void removeMin(int lastUnsortedIndex) {
        int removedMin = backwardHeap[maxIndex];
        backwardHeap[maxIndex] = backwardHeap[lastUnsortedIndex];
        bubbleDown(maxIndex, lastUnsortedIndex);
        backwardHeap[lastUnsortedIndex] = removedMin;

    }


}
