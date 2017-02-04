package com.company;


public class Entry implements Comparable<Entry> {
    private int key;
    private String value;

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    @Override
    public int compareTo(Entry that) {
        if (this.key > that.key) {
            return 1;
        } else if (that.key > this.key) {
            return -1;
        } else {
            return 0;
        }
    }


}
