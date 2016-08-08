package com.company;

/**
 * Created by Home on 8/4/2016.
 */
public class MergeSort {


    public void Sort(LinkedList linkedList) {
        int totalItems = linkedList.getCount();
        int secondHalfBegin =1+(int) (totalItems / 2);
        sort(1, secondHalfBegin - 1);
        sort(secondHalfBegin, totalItems);
    }

    private void sort(int leftListBegin, int rightListBegin) {
        if ((rightListBegin - leftListBegin) > 1) {
            int totalItems = (rightListBegin - leftListBegin) + 1;
            int secondHalfBegin = leftListBegin + (int) (totalItems / 2);

            sort(leftListBegin, secondHalfBegin - 1);
            sort(secondHalfBegin, totalItems);
            merge(leftListBegin, secondHalfBegin - 1, secondHalfBegin, totalItems);
        }
        else
        {
            System.out.println("--------------");
            System.out.println("reached down to single nodes");
            System.out.println(String.format("merge %s and %s",leftListBegin,rightListBegin));
            System.out.println("--------------");
        }
    }

    private void merge(int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
        System.out.println("leftBegin:" + leftBegin);
        System.out.println("leftEnd:" + leftEnd);
        System.out.println("rightBegin:" + rightBegin);
        System.out.println("rightEnd:" + rightEnd);
    }

}
