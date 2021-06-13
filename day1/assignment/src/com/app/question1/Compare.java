// Problem Statement: Write a program to accept two numbers using scanner and compare those two nubmers
package com.app.question1;

import java.util.Scanner;
public class Compare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the two numbers to compare:");
        if (sc.hasNextDouble()) {
            double num1 = sc.nextDouble();
            if (sc.hasNextDouble()) {
                double num2 = sc.nextDouble();
                if (num1 > num2) {
                    System.out.println(num1 + " > " + num2);
                } else if (num1 < num2) {
                    System.out.println(num1 + " < " + num2);
                } else {
                    System.out.println(num1 + " = " + num2);
                }
            } else {
                System.out.println("The data entered is not a number");
                }
        } else {
            System.out.println("The data entered is not a number.");
        }


        if (sc != null) {
            sc.close();
        }
        }
}


