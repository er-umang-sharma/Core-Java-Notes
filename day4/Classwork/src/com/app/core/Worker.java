package com.app.core;

public class Worker extends Employee{

    private int noOfHours;
    private double rate;

    public Worker(String name, String dept, double basic, int noOfHours, double rate) {
        super(name, dept, basic);
        this.noOfHours = noOfHours;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Worker{" +
                "noOfHours=" + noOfHours +
                ", rate=" + rate +
                '}';
    }

    @Override
    public double computeNetSalary() {
        return super.getBasic() + noOfHours * rate;
    }

    public double getHourlyRate() {
        return rate;
    }
}
