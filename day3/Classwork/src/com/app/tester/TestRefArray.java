package com.app.tester;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.app.core.Box;
public class TestRefArray {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of elements you want the array to be created:");
            Box[] array = new Box[sc.nextInt()];

            for (int i=0; i<array.length; i++) {
                System.out.println("Enter details of Box " + (i+1));
                array[i] = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            }

            System.out.println("The data entered is:");
            for (Box num: array) {
                System.out.print(num + "\t");
            }
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid input type.");
        }
    }
}
