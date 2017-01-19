package com.company;

/**
 * Does a radix sort on positive integers
 */
public class RadixSort {

    Bucket[] buckets;
    int[] numbersToSort;

    public void sort(int[] nums) {
        this.numbersToSort = nums;

        int max = getMax(numbersToSort);
        int radix = 10;//we are assuming base 10 numbers
        int maxDigits = findMaxDigits(max, radix);

        for (int d = 1; d <= maxDigits; d++) {
            initializeBuckets(radix);
            putInBuckets(d, radix);
            writeBackOutToArrayFromBuckets();
        }

    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }


    /*return int of log plus 1*/
    private int findMaxDigits(int num, int base) {
        if (num < 0) {
            num = num * (-1);
        }

        int maxDigits = (int) getLog(num, base) + 1;
        return maxDigits;

    }

    private double getLog(int num, int base) {
        return (Math.log10(num)) / (Math.log10(base));

    }

    private int getDigit(int num, int digitPosFromRight, int base) {
        int modBy = base;
        int divideBy = 1;
        for (int i = 1; i < digitPosFromRight; i++) {
            modBy = modBy * base;
        }

        for (int i = 1; i < digitPosFromRight; i++) {
            divideBy = divideBy * base;
        }
        int digitOfInterest = (int) ((num % modBy) / divideBy);

        return digitOfInterest;

    }

    /*
    * Put numbers into buckets
    * For example numbers ending with 0 go to bucket 0
    * Numbers ending in 1 go to bucket 1
    * If you are sorting by say the second digit,
    * then numbers with second digit 0 go to bucket zero.
    * Numbers with second digit 1 go to bucket 1
    * */
    private void putInBuckets(int sortByDigit, int radix) {
        for (int i = 0; i < numbersToSort.length; i++) {
            int num = numbersToSort[i];
            int bucketNumber = getDigit(num, sortByDigit, radix);
            buckets[bucketNumber].add(num);
        }
    }

    private void initializeBuckets(int radix) {

        buckets = new Bucket[radix];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    private void writeBackOutToArrayFromBuckets() {
        int inputArrayIndexNumber = 0;
        //For every bucket
        for (Bucket bucket : buckets) {
            if (bucket != null && bucket.getCount() > 0) {
                //Empty out the bucket into the input array
                while (bucket.getCount() > 0) {
                    numbersToSort[inputArrayIndexNumber] = bucket.remove();
                    inputArrayIndexNumber++;
                }

            }

        }
    }
}
