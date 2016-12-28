package com.company;

import java.util.Random;

public class Main {

    private static int expectedComplexity;
    private static int measuredComplexity = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 5, 2, 9, 7, 3, 0, 0, 8, 8, 36, 5, 4};
        expectedComplexity = (int) (arr.length * (Math.log(arr.length) / Math.log(2)));
        System.out.println("Before sort");
        printArray(arr);
        quicksort(0, arr.length - 1, arr);
        System.out.println("After sort");
        printArray(arr);
        System.out.println("Expected complexity according to nlogn: " + expectedComplexity);
        System.out.println("Measured complexity: " + measuredComplexity);
    }

    private static void quicksort(int beginIndex, int endIndex, int[] array) {
        if (beginIndex >= endIndex) {
            return;
        }

        Random rand = new Random();
        int pivotIndex = rand.nextInt(endIndex - beginIndex) + beginIndex;
        int pivotElement = array[pivotIndex];
        swap(pivotIndex, endIndex, array);
        int i = beginIndex;
        int j = endIndex - 1;

        while (true) {
            while (array[i] <= pivotElement && i <= j) {
                measuredComplexity++;
                i++;
            }

            while (array[j] > pivotElement && j > 0 && j >= i) {
                measuredComplexity++;
                j--;
            }

            if (j > i) {
                swap(i, j, array);
            } else if (j < i || j == 0) {
                swap(i, endIndex, array);
                break;
            }

        }

        //go left
        if (beginIndex < i - 1) {
            quicksort(beginIndex, i - 1, array);
        }


        //go right
        if (i + 1 < endIndex) {
            quicksort(i + 1, endIndex, array);
        }


    }

    private static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("");
    }

}
