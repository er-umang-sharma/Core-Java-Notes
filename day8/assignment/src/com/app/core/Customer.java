package com.app.core;

import java.util.Date;
import java.util.Objects;

public class Customer {

    private String email, password;
    private double regAmount;
    private Date dateOfBirth;

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
}
