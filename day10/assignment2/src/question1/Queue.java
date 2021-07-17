package question1;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Queue {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            LinkedList<Double> list = new LinkedList<>();
            boolean exit = false;
            while (!exit) {
                try {
                    System.out.println("----------MENU----------");
                    System.out.println("QUEUE Operations:");
                    System.out.println("1. Add an element");
                    System.out.println("2. Delete an element");
                    System.out.println("3. Display all the elements in the queue.");
                    System.out.println("0. Exit");
                    System.out.println("------------------------");

                    System.out.print("Please enter your choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.print("Please enter an integer number to input:");
                            double numberEnter = sc.nextDouble();
                            list.addLast(numberEnter);
                            System.out.println("Number " + numberEnter + " added successfully to the Queue");
                            break;

                        case 2:
                            double numberRemoved = list.removeFirst();
                            System.out.println(numberRemoved + " removed from the Queue");
                            break;

                        case 3:
                            System.out.println("The elements of the Queue are:");
                            for (double i: list)
                                System.out.println(i);
                            break;

                        case 0:
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The data you entered is not valid.");
                    sc.nextLine();
                }
            }
        }
    }
}
