package com.app.core;

public class Student extends Person{
    private int gradYear;

    public Student(String fname, String lname, int gradYear) {
        super(fname, lname);
        this.gradYear = gradYear;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Student{" +
                "gradYear=" + gradYear +
                '}';
    }
}
