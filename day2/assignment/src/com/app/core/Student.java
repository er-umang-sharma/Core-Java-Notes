package com.app.core;

public class Student {

    private static int idGenerator;
    private int id, age;
    private String name, email;
    private double gpa;

    public Student(String name, String email, int age, double gpa) {
        this.id = ++idGenerator;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gpa = gpa;
    }

    public String fetchDetails() {
        return "ID: " + this.id + "\nName: " + this.name + "\nEmail: " + this.email + "\nAge: " + this.age + "\nGPA: " + this.gpa;
    }
}
