package com.app.core;

public class Person {

    private String fname, lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}