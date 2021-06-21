package com.app.tester;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.app.core.Customer;
import cust_excs.CustomerHandlingException;
import static util.ValidationRules.*;

public class Tester {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            boolean exit = false;
            System.out.print("Enter the size of the array:");
            Customer[] customers = new Customer[sc.nextInt()];
            int counter=0;

            while (!exit) {

                try {

                    System.out.println("-----------MENU------------");
                    System.out.println("1. Register a customer.");
                    System.out.println("2. Display the list of customers.");
                    System.out.println("10. Exit");
                    System.out.println("---------------------------");
                    System.out.println("Enter your choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter email, password and the registration amount:");
                            customers[counter++] = new Customer(validateEmail(sc.next()), validatePassword(sc.next()), validateRegAmount(sc.nextDouble()));
                            break;

                        case 2:
                            System.out.println("The list of customers are:");
                            for (int i = 0; i < counter; i++)
                                System.out.println(customers[i]);
                            break;

                        case 10:
                            System.out.println("Exiting the program.\nThank you.");
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input");

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input.");
                    sc.nextLine();
                } catch (CustomerHandlingException e) {
                    e.printStackTrace();
                    sc.nextLine();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input.");
        }
    }
}
