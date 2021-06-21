package com.app.core;

public class Employee {

    private final int id;
    private String email, name, dept;
    private double basic;
    private static int idGenerator;
    static {
        idGenerator = 1000;
    }

    public Employee(String email, String name, String dept, double basic) {
        this.id = idGenerator++;
        this.email = email;
        this.name = name;
        this.dept = dept;
        this.basic = basic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", basic=" + basic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }
}
