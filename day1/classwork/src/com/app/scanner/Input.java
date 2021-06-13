// Problem Statement: Write a program to take two numbers as input using Scanner class and print it's product
package com.app.scanner;

import java.util.Scanner;
public class Input {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers to print it's product:");
        if (sc.hasNextDouble()) {
            double num1 = sc.nextDouble();
            if (sc.hasNextDouble()) {
                double num2 = sc.nextDouble();
                System.out.println("The product: " + num1 * num2);
            } else {
            System.out.println("The data entered is not a number");
            }

        } else {
            System.out.println("The data entered is not a number");
        }

        if (sc != null) {
            sc.close();
        }
    }
}
