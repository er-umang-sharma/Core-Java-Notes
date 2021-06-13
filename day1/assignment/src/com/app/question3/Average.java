// Problem Statement: Write a program to accept two numbers using scanner and print it's average using Scanner
package com.app.question3;

import java.util.Scanner;
public class Average {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter two numbers to compute average:");
        if (sc.hasNextDouble()) {
            double num1 = sc.nextDouble();
            if (sc.hasNextDouble()) {
                double num2 = sc.nextDouble();

                System.out.println("The average is: " + ((num1 + num2)/2));

            } else {
                System.out.println("The data entered is not a number thus cannot calculate the average.");
            }
        } else {
            System.out.println("The data entered is not a number thus cannot calculate the average.");
        }
    }
}
