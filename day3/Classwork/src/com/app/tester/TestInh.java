package com.app.tester;

import com.app.core.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestInh {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the name and the graduation year of the Student: ");
            Student s = new Student(sc.next(), sc.next(), sc.nextInt());
            System.out.println(s);
        }  catch(InputMismatchException e) {
            System.out.println("The data entered is not in a valid format.");
        }
    }
}
