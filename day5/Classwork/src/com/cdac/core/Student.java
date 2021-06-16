package com.cdac.core;

public class Student extends Person {

    private int gradYear;
    private String courseName;

    public Student(String firstName, String lastName, int gradYear, String courseName) {
        super(firstName, lastName);
        this.gradYear = gradYear;
        this.courseName = courseName;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + super.firstName + " and I graduated in " + this.gradYear);
    }

    public void feedback() {
        System.out.println("Feedback submitted. ");
    }

    @Override
    public String toString() {
        return super.toString() + " gradYear=" + gradYear +
                ", courseName='" + courseName + '\'';
    }
}
