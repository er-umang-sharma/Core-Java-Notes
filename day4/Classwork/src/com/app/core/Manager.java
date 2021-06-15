package com.app.core;

public class Manager extends Employee{

    private double perfBonus;

    public Manager(String name, String dept, double basic, double perfBonus) {
        super(name, dept, basic);
        this.perfBonus = perfBonus;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Manager{" +
                "perfBonus=" + perfBonus +
                '}';
    }

    @Override
    public double computeNetSalary() {
        return super.getBasic() + perfBonus;
    }

    public double getPerfBonus() {
        return perfBonus;
    }
}
