package com.app.core;

public class Customer {
    private String email, password;
    private double regAmount;

    public Customer(String email, String password, double regAmount) {
        this.email = email;
        this.password = password;
        this.regAmount = regAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regAmount=" + regAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return email.equals(customer.email) && password.equals(customer.password);
    }
}
