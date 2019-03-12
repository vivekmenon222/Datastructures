package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        KmpMatcher mchr=new KmpMatcher();
        //other patterns abcababcabcab
        int idx= mchr.findPattern("abcxabcdabxabcdabcdabcdabcy","abcdabcy");
        System.out.println(idx);
        int idx2= mchr.findPattern("abcxabcdabxabcdabcdabcdabcy","");
        System.out.println(idx2);
    }
}
