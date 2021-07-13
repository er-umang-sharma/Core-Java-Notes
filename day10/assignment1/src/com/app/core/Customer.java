package com.app.core;

import java.util.Date;

public class Customer implements Comparable<Customer> {

    private String email, password;
    private Double regAmount;
    private Date dateOfBirth;

    public Customer(String email) {
        this.email = email;
    }

    public Customer(String email, String password, Double regAmount, Date dateOfBirth) {
        this.email = email;
        this.password = password;
        this.regAmount = regAmount;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer c = (Customer) o;
        return email.equals(c.email);
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
    public int compareTo(Customer c) {
        return this.email.compareTo(c.email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public double getRegAmount() {
        return regAmount;
    }
}
