package com.app.tester;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPrimArray {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of elements you want the array to be created:");
            double[] array = new double[sc.nextInt()];

            System.out.println("Enter " + array.length + " numbers:");
            for (int i=0; i<array.length; i++) {
                array[i] = sc.nextDouble();
            }

            System.out.println("The data entered is:");
            for (double num: array) {
                System.out.print(num + "\t");
            }
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid input type.");
        }
    }
}
