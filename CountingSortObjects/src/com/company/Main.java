package com.company;

public class Main {

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0, "A"),
                new Item(2, "B"),
                new Item(4, "F"),
                new Item(0, "A2"),
                new Item(2, "B5"),
                new Item(3, "T"),
        };

        int[] counts = new int[5];//indexes 0 to 4

        //prepare counts array
        for (int i = 0; i < items.length; i++) {
            counts[items[i].getKey()]++;
        }

        //Now make every element in counts array the sum of all the elements to the left of it.

        int sumTillLast = 0;
        for (int i = 0; i < counts.length; i++) {
            int currentElement = counts[i];
            counts[i] = sumTillLast;
            sumTillLast = sumTillLast + currentElement;
        }

        Item[] outputArray = new Item[items.length];

        //Now insert elements into output array
        //based on their indexes in the counts array

        for (int i = 0; i < items.length; i++) {
            int positionOfInsert = counts[items[i].getKey()];
            outputArray[positionOfInsert] = items[i];
            counts[items[i].getKey()]++;
        }


    }
}
