/**
 * Problem Statement: Build a core class to be extended by other classes for it's use
 */
package com.app.core;

public abstract class Employee {

    private int id;
    private String name, dept;
    private double basic;

    // Static ID counter
    private static int idCounter;

    public Employee(String name, String dept, double basic) {
        this.id = ++idCounter;
        this.name = name;
        this.dept = dept;
        this.basic = basic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", basic=" + basic +
                '}';
    }

    public abstract double computeNetSalary();

    public double getBasic() {
        return basic;
    }
}
