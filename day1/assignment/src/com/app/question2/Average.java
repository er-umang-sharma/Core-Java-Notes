// Problem Statement: Write a program to take two or more numbers as input from the command line and compute it's average
package com.app.question2;

public class Average {

    public static void main(String[] args){

        if (args.length < 2) {
            System.out.println("Please enter two or more numbers to compute average.");
            System.exit(0);
        }

        double sum = 0;
        int notNumberCount = 0;
        for (String num: args) {
            try {
                sum += Double.parseDouble(num);
            } catch(Exception e) {
                System.out.println(num + " is not a number and thus skipping for average calculation.");
                notNumberCount++;
            }
        }

        System.out.println("The average of the list is: " + (sum / (args.length - notNumberCount)));
    }
}

