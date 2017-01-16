package com.company;

public class Main {

    public static void main(String[] args) {
        String str = getText().toLowerCase();
        char[] charArray = str.toCharArray();
        int[] counts = new int[26];


        //Every time a character occurs, increment its array position by 1
        //I am putting a in index 0, b in index 1 and so on.
        for (char chr : charArray) {
            counts[(chr - 'a')]++;
        }

        //Now go through position array and print out every character
        //for the number of times it occurs.
        //For example if counts[0]=2 then print a twice.
        // Because 0 position denotes how many times a occurs
        for (int index = 0; index < counts.length; index++) {
            int numOfOccurances = counts[index];
            for (int x = 1; x <= numOfOccurances; x++) {

                char chr = (char) (index + 'a');
                System.out.print(chr + " ");
            }
        }


    }

    private static String getText() {
        return "abcdddxbca";//sorted vale is aabbccdddx
    }
}
