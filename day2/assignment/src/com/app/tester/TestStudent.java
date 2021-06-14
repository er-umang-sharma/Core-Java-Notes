package com.app.tester;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.app.core.Student;
public class TestStudent {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Name, Email, Age and GPA of the 1st student:");
            Student stud1 = new Student(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            System.out.println("Enter the Name, Email, Age and GPA of the 2nd student:");
            Student stud2 = new Student(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());

            System.out.println("The details of the two students are:\nStudent 1:\n" + stud1.fetchDetails() + "\n\nStudent 2:\n" + stud2.fetchDetails());
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not in a valid input format.");
        }
    }
}
