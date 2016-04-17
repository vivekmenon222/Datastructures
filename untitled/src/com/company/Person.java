package com.company;

public class Person {
    String name;
    int age;
    String socialSecurityNumber;

    public Person(String name, int age, String socialSecurityNumber) {
        this.name = name;
        this.age = age;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public boolean equals(Object p) {
        //Person is same if social security number is same

        if ((p instanceof Person) && this.socialSecurityNumber.equals(((Person) p).socialSecurityNumber)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {        //I am using a hashing function in String.java instead of writing my own.
        return socialSecurityNumber.hashCode();
    }
}
