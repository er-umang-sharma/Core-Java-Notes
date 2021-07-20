package com.app.core;

public class Student {

    private String name;
    private double number1, number2, number3, number4, number5;

    public Student(String name, double number1, double number2, double number3, double number4, double number5) {
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
    }

    public String getName() {
        return name;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public double getNumber3() {
        return number3;
    }

    public double getNumber4() {
        return number4;
    }

    public double getNumber5() {
        return number5;
    }
}
