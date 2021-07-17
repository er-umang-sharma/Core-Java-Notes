package com.app.core;

import java.util.Date;
import java.util.Objects;

public class Customer implements Comparable<Customer>{

    private String email, password;
    private double regAmount;
    private Date dateOfBirth;

    public Customer(String email) {
        this.email = email;
    }

    public Customer(String email, String password, double regAmount, Date dateOfBirth) {
        this.email = email;
        this.password = password;
        this.regAmount = regAmount;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return email.equals(customer.email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regAmount=" + regAmount +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.email.compareTo(o.email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRegAmount() {
        return regAmount;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

}
