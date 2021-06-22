package com.app.core;
import java.util.Date;

public class Customer {

    private final String email, password;
    private final double regAmount;
    private final Date dateOfBirth;

    public Customer(String email, String password, double regAmount, Date dateOfBirth) {
        this.email = email;
        this.password = password;
        this.regAmount = regAmount;
        this.dateOfBirth = dateOfBirth;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        return this.email.equals(((Customer) o).email);
    }
}