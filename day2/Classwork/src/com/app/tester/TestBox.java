package com.app.tester;

import com.app.core.Box;

import java.util.Scanner;
import java.util.InputMismatchException;
public class TestBox {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of the Box:");
        try {
            Box b = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            System.out.println("The details of the Box input are:");
            b.displayDetails();
            System.out.println("The volume of the box is: " + b.calcVolume());
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid input.");
        } finally {
            sc.close();
        }
    }
}
