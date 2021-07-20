package com.app.core;

import java.util.Date;

public class Customer {

    private String name;
    private double registrationAmount;
    private Date registrationDate;

    public Customer(String name, double registrationAmount, Date registrationDate) {
        this.name = name;
        this.registrationAmount = registrationAmount;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public double getRegistrationAmount() {
        return registrationAmount;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
