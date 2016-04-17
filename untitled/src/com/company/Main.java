package com.company;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

       Person p1=new Person("Tom",32,"548-56-4412");
        Person p2=new Person("Jerry",60,"456-74-4125");
        Person p3=new Person("Sherry",38,"418-55-1235");

        Order order1=new Order();
        order1.insertOrder(new String[]{"mouse","car charger"});

        Order order2=new Order();
        order2.insertOrder(new String[]{"Multi vitamin"});

        Order order3=new Order();
        order3.insertOrder(new String[]{"handbag", "iPod"});

        Hashtable<Person,Order> hashtable=new Hashtable<Person,Order>();
        hashtable.put(p1,order1);
        hashtable.put(p2,order2);
        hashtable.put(p3,order3);

       Order tomOrder= hashtable.get(new Person("Sherry",38,"418-55-1235"));
        for(String item:tomOrder.items)
        {
            System.out.println(item);
        }
    }
}
