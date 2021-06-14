package com.app.core;

public class Box {

    private double length, breadth, height;

    public Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Box{" +
                "length=" + length +
                ", breadth=" + breadth +
                ", height=" + height +
                '}';
    }
}
