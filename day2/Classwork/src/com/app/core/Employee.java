package com.app.core;

public class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getDetails() {
        return "ID: " + this.id + "\nName: " + this.name + "\nSalary: Rs" + this.salary;
    }
}
