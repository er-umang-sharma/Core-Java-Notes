package com.app.tester;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.app.core.Employee;

public class TestEmployee {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the ID, Name and salary of the Employee");
            Employee emp = new Employee(sc.nextInt(), sc.next(), sc.nextDouble());

            System.out.println("The details entered for the employee are:" + emp.getDetails());
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not of correct type.");
        }
    }
}
