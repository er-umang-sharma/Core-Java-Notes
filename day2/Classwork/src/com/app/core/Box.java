package com.app.core;

public class Box {

    private double length, height, breadth;
    public Box(double length, double height, double breadth) {
        this.length = length;
        this.height = height;
        this.breadth = breadth;
    }

    public void displayDetails() {
        System.out.println("The detials are: \nLength: " + this.length + "\nBreadth: " + this.breadth + "\nHeight: " + height );
    }

    public double calcVolume() {
        return this.length * this.height * this.breadth;
    }
}
