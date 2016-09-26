package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Home on 8/4/2016.
 */
public class MergeSort {


    public void Sort(int[] sortMe) throws Exception {
        int totalItems = sortMe.length;
        split(0, totalItems - 1, sortMe);
    }

    private void split(int leftIndex, int rightIndex, int[] sortMe) throws Exception {

        if ((rightIndex - leftIndex) >= 1) {
            if ((rightIndex - leftIndex) == 1) {
                //down to single nodes
                merge(leftIndex, leftIndex, rightIndex, rightIndex, sortMe);
            } else {
                int rightBeginIndex = secondHalfBegin(leftIndex, rightIndex);
                int leftEndIndex = rightBeginIndex - 1;
                if (leftEndIndex > leftIndex) {
                    split(leftIndex, leftEndIndex, sortMe);
                }

                if (rightIndex > rightBeginIndex) {
                    split(rightBeginIndex, rightIndex, sortMe);
                }

                merge(leftIndex, leftEndIndex, rightBeginIndex, rightIndex, sortMe);
            }

        }
    }

    private int secondHalfBegin(int firstIndex, int lastIndex) throws Exception {
        //We are keeping left array the bigger array.
        if (lastIndex > 0) {
            return (int) ((lastIndex - firstIndex) / 2) + firstIndex + 1;
        } else {
            throw new Exception("Only one item. Cannot split into two.");
        }

    }

    private void merge(int leftBegin, int leftEnd, int rightBegin, int rightEnd, int[] sortMe) {

        int mergedLength=(leftEnd-leftBegin)+(rightEnd-rightBegin)+2;

        int[] merged=new int[mergedLength];
        int leftPointer=leftBegin;
        int rightPointer=rightBegin;
        int mergeIndex=0;

        while(leftPointer<=leftEnd && rightPointer<=rightEnd )
        {
            if(sortMe[leftPointer]<sortMe[rightPointer])
            {
                merged[mergeIndex]=sortMe[leftPointer];
                leftPointer++;
            }
            else
            {
                merged[mergeIndex]=sortMe[rightPointer];
                rightPointer++;
            }

            mergeIndex++;
        }

        if(leftPointer>leftEnd)
        {
            //This means you wnet thru all the items in left
            //So now copy the remaining right items into merged
            while(rightPointer<=rightEnd)
            {
                merged[mergeIndex]=sortMe[rightPointer];
                rightPointer++;
                mergeIndex++;
            }

        }
        else if(rightPointer>rightEnd)
        {
            //This means you wnet thru all the items in right
            //So now copy the remaining left items into merged
            while(leftPointer<=leftEnd)
            {
                merged[mergeIndex]=sortMe[leftPointer];
                leftPointer++;
                mergeIndex++;
            }
        }

        //Copy items from merged back into the array
        mergeIndex=0;
        for(int i=leftBegin;i<=rightEnd;i++)
        {
            sortMe[i]=merged[mergeIndex];
            mergeIndex++;
        }


    }


}
