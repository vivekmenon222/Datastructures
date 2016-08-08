package com.company;

/**
 * Created by Home on 8/4/2016.
 */
public class MergeSort {


    public void Sort(LinkedList linkedList) {
        int totalItems = linkedList.getCount();
        int secondHalfBegin = 1 + (int) (totalItems / 2);
        sort(1, secondHalfBegin - 1);
        sort(secondHalfBegin, totalItems);
    }

    private void sort(int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) > 1) {
            int totalItems = (rightIndex - leftIndex) + 1;
            int secondHalfBegin = leftIndex + (int) (totalItems / 2);
            int leftEnd = secondHalfBegin - 1;
            if (leftEnd > leftIndex) {
                //for 3 items this could be 1 item long
                //don't call sort for that
                sort(leftIndex, leftEnd);
            }

            sort(secondHalfBegin, rightIndex);
            merge(leftIndex, secondHalfBegin - 1, secondHalfBegin, rightIndex);
        } else {
            System.out.println("--------------");
            System.out.println("reached down to single nodes");
            System.out.println(String.format("merge %s and %s", leftIndex, rightIndex));
            System.out.println("--------------");
        }
    }

    private void merge(int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
        //left begin and end can be same for 3 items. Account for that
        System.out.println("--------------");
        System.out.println("Merging lists");
        System.out.println("leftBegin:" + leftBegin);
        System.out.println("leftEnd:" + leftEnd);
        System.out.println("rightBegin:" + rightBegin);
        System.out.println("rightEnd:" + rightEnd);
        System.out.println("--------------");
    }

}
