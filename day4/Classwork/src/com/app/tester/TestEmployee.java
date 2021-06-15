package com.app.tester;

import com.app.core.Employee;
import com.app.core.Manager;
import com.app.core.Worker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestEmployee {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the organization size:");
            Employee[] employees = new Employee[sc.nextInt()];
            boolean exit = false;

            int counter = 0;
            while (!exit) {
                if (counter == employees.length) {
                    System.out.println("The length of your organization size is full.");
                    exit = true;
                    break;
                }
                System.out.println("Your choice: \n1. Hire a manager.\n2. Hire a worker.\n0. Exit");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the name, department id, basic pay and performance bonus:");
                        employees[counter++] = new Manager(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
                        break;

                    case 2:
                        System.out.println("Enter the name, department id, basic pay, no of hours and hourly rate:");
                        employees[counter++] = new Worker(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
                        break;

                    case 0:
                        exit = true;
                        break;

                    default:
                        System.out.println("Please enter a valid choice.");
                }
            }

            System.out.println("The details of the employees are:");
            System.out.println("---------------------------------");
            for (int i=0; i<counter; i++) {
                Employee e = employees[i];
                System.out.println(e);
                System.out.println("---------------------------------");

                if (e instanceof Manager) {
                    System.out.println("Performance bonus: Rs" + ((Manager)e).getPerfBonus());
                } else {
                    System.out.println("Hourly rate: Rs" + ((Worker)e).getHourlyRate());
                }
                System.out.println("---------------------------------");
            }
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not in a valid format.");
        }
    }
}
