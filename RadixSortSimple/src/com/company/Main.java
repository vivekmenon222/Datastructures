package com.company;

public class Main {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 5, 16, 54, 3, 100, 2, 46, 2200, 22};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }


}
