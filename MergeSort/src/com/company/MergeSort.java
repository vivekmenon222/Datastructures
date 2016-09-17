package com.company;

/**
 * Created by Home on 8/4/2016.
 */
public class MergeSort {


    public void Sort(LinkedList linkedList) throws Exception {
        int totalItems = linkedList.getCount();
        split(0, totalItems - 1);
    }

    private void split(int leftIndex, int rightIndex) throws Exception {

        if ((rightIndex - leftIndex) >= 1) {
            if ((rightIndex - leftIndex) == 1) {
                //down to single nodes
                merge(leftIndex, leftIndex, rightIndex, rightIndex);
            } else {
                int rightBeginIndex = secondHalfBegin(leftIndex, rightIndex);
                int leftEndIndex = rightBeginIndex - 1;
                if (leftEndIndex > leftIndex) {
                    split(leftIndex, leftEndIndex);
                }

                if (rightIndex > rightBeginIndex) {
                    split(rightBeginIndex, rightIndex);
                } else if (rightIndex == rightBeginIndex) {
                    //down to single node right
                    merge(leftIndex, leftEndIndex, rightIndex, rightIndex);
                }
                System.out.println("-----back track-----");
                System.out.println("leftBegin:" + leftIndex);
                System.out.println("rightEnd:" + rightIndex);
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

    private void merge(int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
        //left begin and end can be same for 3 items. Account for that
       /* System.out.println("--------------");
        System.out.println("Merging lists");
        System.out.println("leftBegin:" + leftBegin);
        System.out.println("rightEnd:" + rightEnd);
        System.out.println("--------------");*/
    }

}
