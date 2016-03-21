package com.company;

import java.awt.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap h=new HashMap();
        Object o2=new Object();
        Object o=new Object();

        System.out.println(o.hashCode());

        System.out.println(o2.hashCode());

        MyCollection<Integer> myCollection=new MyCollection<>();
        System.out.println(myCollection.hashCode());
    }
}
