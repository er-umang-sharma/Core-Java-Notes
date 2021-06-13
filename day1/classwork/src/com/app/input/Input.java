// Problem Statement: Write a program to take two numbers as input using command line and print it's product

package com.app.input;

public class Input {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("The list of data entered is less than 2");
            System.exit(0);
        }
        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);

            System.out.println("The product is: " + num1 * num2);
        } catch(Exception e) {
            System.out.println("The data entered is not a number");
        }
    }
}

